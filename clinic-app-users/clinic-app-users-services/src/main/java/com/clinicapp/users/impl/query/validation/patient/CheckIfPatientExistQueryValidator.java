package com.clinicapp.users.impl.query.validation.patient;


import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.query.definition.patient.query.CheckIfPatientExistQuery;

public class CheckIfPatientExistQueryValidator {

    public static void validate(CheckIfPatientExistQuery query) throws ClinicAppException {
        if(query == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_QUERY);
        }

        if(query.getPatientId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_PATIENT_ID);
        }
    }
}
