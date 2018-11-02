package com.clinicapp.users.impl.command.domain.patient.factory;

import com.clinicapp.libs.constants.Role;
import com.clinicapp.users.api.command.definition.patient.CreatePatientCommand;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;
import com.clinicapp.users.impl.command.datatypes.entity.address.Address;
import com.clinicapp.users.impl.command.datatypes.entity.identificationnumber.IdentificationNumber;
import com.clinicapp.users.impl.command.domain.PasswordGenerator;

import static com.clinicapp.libs.constants.Constants.PASSWORD_LENGTH;
import static com.clinicapp.libs.constants.Constants.PATIENT_PERMISSIONS;

public class PatientFactory {

    public static Patient create(CreatePatientCommand command) {

        Patient patient = new Patient();

        //GENERAL INFO
        patient.setFirstName(command.getFirstName());
        patient.setFamilyName(command.getFamilyName());
        patient.setSex(command.getSex());
        patient.setBirthDate(command.getBirthDate());

        //CONTACT PHONE
        patient.setContactPhone(command.getContactPhone());
        patient.setContactPhoneCC(command.getContactPhoneCC());

        //PATIENT PHONE
        patient.setPatientPhone(command.getPatientPhone());
        patient.setPatientPhoneCC(command.getPatientPhoneCC());

        //PATIENT ACCOUNT SETTINGS
        patient.setEmail(command.getEmail());
        patient.setLogin(command.getIdentificationNumberValue());
        patient.setPassword(PasswordGenerator.generate(PASSWORD_LENGTH));
        patient.setRole(Role.PATIENT);
        patient.setCreationTime(System.currentTimeMillis());
        patient.setPermissions(PATIENT_PERMISSIONS);

        //IDENTIFICATION NUMBER
        IdentificationNumber identificationNumber = new IdentificationNumber();
        identificationNumber.setType(command.getIdentificationNumberType());
        identificationNumber.setValue(command.getIdentificationNumberValue());

        //ADDRESS
        Address address = new Address();
        address.setCity(command.getCity());
        address.setStreet(command.getStreet());
        address.setHouseNumber(command.getHouseNumber());
        address.setFlatNumber(command.getFlatNumber());

        return patient;

    }
}
