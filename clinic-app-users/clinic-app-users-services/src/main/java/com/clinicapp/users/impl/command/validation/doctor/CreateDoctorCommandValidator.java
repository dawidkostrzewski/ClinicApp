package com.clinicapp.users.impl.command.validation.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.command.definition.doctor.CreateDoctorCommand;

public class CreateDoctorCommandValidator {

    public static void validate(CreateDoctorCommand command) throws ClinicAppException {

        if(command == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_COMMAND);
        }

        if(command.getEmail() == null || command.getEmail().isEmpty()) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_EMAIL);
        }

        if(command.getWorkingHours() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DOCTOR_WORK_HOURS);
        }

        if(command.getFirstName() == null || command.getFirstName().isEmpty()) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_FIRST_NAME);
        }

        if(command.getFamilyName() == null || command.getFamilyName().isEmpty()) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_FAMILY_NAME);
        }
    }
}
