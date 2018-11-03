package com.clinicapp.users.impl.command.repo.identificationnumber;

import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.impl.command.datatypes.entity.identificationnumber.IdentificationNumberType;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class IdentificationNumberTypeRepo extends AbstractRepo<IdentificationNumberType> {

    @PersistenceContext(name = "public")
    private EntityManager entityManager;

    @PostConstruct
    private void init() {
        super.setEntityManager(entityManager);
    }
}
