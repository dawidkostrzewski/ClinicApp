package com.clinicapp.libs.handler;


import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;

public abstract class AbstractHandler<T> {

    public void checkIfExist(T entity) throws ClinicAppException {
        if(entity == null) {
            throw new ClinicAppException(ExceptionsTokens.ENTITY_NOT_FOUND);
        }
    }
}
