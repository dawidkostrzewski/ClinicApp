package com.clinicapp.users.impl.query.validation.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorsListQuery;

public class GetDoctorsListQueryValidator {

    public static void validate(GetDoctorsListQuery query) throws ClinicAppException {
        if(query == null ) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_QUERY);
        }
    }
}
