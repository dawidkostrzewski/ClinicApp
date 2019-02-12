package com.clinicalapp.visits.impl.query.validation;


import com.clinicalapp.visits.api.query.definition.query.GetAvailableVisitTimesByDoctorAndPatientIdQuery;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;

public class GetAvailableVisitTimesByDoctorAndPatientIdQueryValidator {

    public static void validate(GetAvailableVisitTimesByDoctorAndPatientIdQuery query) throws ClinicAppException {

        if(query == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_QUERY);
        }

        if(query.getPatientId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_PATIENT_ID);
        }

        if(query.getDoctorId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DOCTOR_ID);
        }

        if(query.getSelectedDate() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_VISIT_TIME);
        }
    }
}
