package com.clinicapp.users.impl.query.validation.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.query.definition.doctor.CheckIfDoctorExistQuery;

public class CheckIfDoctorExistQueryValidator {

    public static void validate(CheckIfDoctorExistQuery query) throws ClinicAppException {
        if(query == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_QUERY);
        }

        if(query.getDoctorId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DOCTOR_ID);
        }
    }
}
