package com.clinicapp.users.impl.command.validation.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.command.definition.patient.CreatePatientCommand;

public class CreatePatientCommandValidator {

    public static void validate(CreatePatientCommand command) throws ClinicAppException {
        if(command == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_COMMAND);
        }
    }
}
