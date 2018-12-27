package com.clinicapp.users.impl.query.validation.doctor;


import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorWorkTimesForSelectedDateQuery;

public class GetDoctorWorkTimesForSelectedDateQueryValidator {

    public static void validate(GetDoctorWorkTimesForSelectedDateQuery query) throws ClinicAppException {
        if(query == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_QUERY);
        }

        if(query.getDoctorId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DOCTOR_ID);
        }

        if(query.getDate() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_VISIT_TIME);
        }
    }
}
