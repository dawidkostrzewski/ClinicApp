package com.clinicapp.users.impl.command.validation.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.users.api.command.definition.patient.CreatePatientCommand;

public class CreatePatientCommandValidator {

    public static void validate(CreatePatientCommand command) throws ClinicAppException {
        if(command == null) {
            throw new ClinicAppException(ExceptionsTokens.EMPTY_COMMAND);
        }

        if(command.getDoctorId() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_DOCTOR_ID);
        }

        if(command.getBirthDate() == null
                || command.getEmail() == null
                || command.getFamilyName() == null
                || command.getFirstName() == null
                || command.getSex() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_PATIENT_BASIC_INFO);
        }

        if(command.getCity() == null || command.getStreet() == null || command.getHouseNumber() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_PATIENT_ADDRESS_INFO);
        }

        if(command.getPatientPhone() == null || command.getPatientPhoneCC() == null) {
            throw new ClinicAppException(ExceptionsTokens.MISSING_PATIENT_CONTACT_INFO);
        }
    }
}
