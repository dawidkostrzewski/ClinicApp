package com.clinicalapp.visits.impl.query.validation;


import com.clinicalapp.visits.api.query.definition.query.GetVisitListByDoctorIdInSelectedDateQuery;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;

public class GetVisitListByDoctorIdInSelectedDateQueryValidator {

    public static void validate(GetVisitListByDoctorIdInSelectedDateQuery query) throws ClinicAppException {

        if(query == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_QUERY);
        }

        if(query.getDoctorId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DOCTOR_ID);
        }

        if(query.getSelectedDate() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DATE);
        }
    }
}
