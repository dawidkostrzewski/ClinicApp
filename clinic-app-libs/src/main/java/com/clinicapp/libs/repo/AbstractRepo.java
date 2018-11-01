package com.clinicapp.libs.repo;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;

import javax.ejb.EJBTransactionRolledbackException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractRepo<T> {

    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getEntityType() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class) type.getActualTypeArguments()[0];
    }

    public T getByNamedQuery(String queryName, String paramName, Object paramValue) throws ClinicAppException {
        try {
            TypedQuery<T> query = entityManager.createNamedQuery(queryName, this.getEntityType());
            query.setParameter(paramName, paramValue);

            return query.getSingleResult();

        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.ERROR_WITH_QUERY + " " + queryName);
        } catch (NoResultException e) {
            return null;
        }

    }

    public T getById(UUID id) throws ClinicAppException {
        try {
            return entityManager.find(this.getEntityType(), id);
        } catch (NullPointerException e) {
            throw new ClinicAppException(ExceptionsTokens.ENTITY_NOT_FOUND);
        } catch (IllegalArgumentException e) {
            throw new ClinicAppException(ExceptionsTokens.INVALID_PARAM);
        }
    }

    public T create(T entity) throws ClinicAppException {
        try {
            getEntityManager().persist(entity);
            getEntityManager().flush();
            return entity;
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.CREATE_ERROR);
        }
    }

    public void createList(List<T> entityList) throws ClinicAppException {
        for(T entity : entityList) {
            create(entity);
        }
    }

    public void update(T entity) throws ClinicAppException {
        try {
            entityManager.merge(entity);
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.UPDATE_ERROR);
        }
    }

    public void remove(T entity) throws ClinicAppException {
        try {
            entityManager.remove(entity);
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.REMOVE_ERROR);
        }
    }

    public T getByNamedQuery(String queryName, Class<T> entityClass) throws ClinicAppException {
        try {
            TypedQuery<T> query = getEntityManager().createNamedQuery(queryName, entityClass);

            return query.getSingleResult();

        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.ERROR_WITH_QUERY + " " + queryName);
        }
    }

    public List<T> getRangeByNamedQuery(String queryName, List<String> paramsNames, List<Object> paramsValues) throws ClinicAppException {
        try {
            if (paramsNames.size() != paramsValues.size()) {
                throw new ClinicAppException(ExceptionsTokens.INVALID_PARAMS_NUMBER);
            }
            TypedQuery<T> query = getEntityManager().createNamedQuery(queryName, this.getEntityType());
            for (int i = 0; i < paramsNames.size(); i++) {
                query.setParameter(paramsNames.get(i), paramsValues.get(i));
            }

            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<T>();
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.ERROR_WITH_QUERY + " " + queryName);
        }
    }

    public List<T> getRangeByNamedQuery(String queryName, List<String> paramsNames, List<Object> paramsValues,
                                        int limit, int offset) throws ClinicAppException {
        if (paramsNames.size() != paramsValues.size()) {
            throw new ClinicAppException(ExceptionsTokens.INVALID_PARAMS_NUMBER);
        }
        TypedQuery<T> query = getEntityManager().createNamedQuery(queryName, this.getEntityType());
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        for (int i = 0; i < paramsNames.size(); i++) {
            query.setParameter(paramsNames.get(i), paramsValues.get(i));
        }

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<T>();
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.ERROR_WITH_QUERY + " " + queryName);
        }

    }

    public List<T> getRangeByNamedQueryWithSingleParameter(String queryName, String paramName, Object paramValue,
                                                           int limit, int offset) throws ClinicAppException {
        if (paramName == null || paramValue == null) {
            throw new ClinicAppException(ExceptionsTokens.INVALID_PARAMS_NUMBER);
        }
        TypedQuery<T> query = getEntityManager().createNamedQuery(queryName, this.getEntityType());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setParameter(paramName, paramValue);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<T>();
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.ERROR_WITH_QUERY + " " + queryName);
        }
    }

    public List<T> getRangeByNamedQueryWithoutParameters(String queryName, int limit, int offset) throws ClinicAppException {

        TypedQuery<T> query = getEntityManager().createNamedQuery(queryName, this.getEntityType());
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<T>();
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.ERROR_WITH_QUERY + " " + queryName);
        }
    }

    public List<T> searchByNamedQueryWithSingleParameter(String queryName, String paramName, Object paramValue,
                                                         int limit, int offset) throws ClinicAppException {

        TypedQuery<T> query = getEntityManager().createNamedQuery(queryName, this.getEntityType());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setParameter(paramName, "%" + paramValue + "%");

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<T>();
        } catch (EJBTransactionRolledbackException e) {
            throw new ClinicAppException(ExceptionsTokens.ERROR_WITH_QUERY + " " + queryName);
        }
    }
}
