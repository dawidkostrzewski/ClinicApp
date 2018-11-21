package com.clinicalapp.visits.impl.command.validation;


import com.clinicalapp.visits.api.command.definition.CreateVisitCommand;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;

public class CreateVisitCommandValidator {

    public static void validate(CreateVisitCommand command) throws ClinicAppException {
        if(command == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_COMMAND);
        }

        if(command.getDoctorId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DOCTOR_ID);
        }

        if(command.getPatientId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_PATIENT_ID);
        }

        if(command.getVisitTime() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_VISIT_TIME);
        }
    }
}
