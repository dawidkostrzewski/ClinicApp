package com.clinicapp.users.impl.query.validation.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientsListQuery;

public class GetPatientListQueryValidator {

    public static void validate(GetPatientsListQuery query) throws ClinicAppException {
        if(query == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_QUERY);
        }
    }
}
