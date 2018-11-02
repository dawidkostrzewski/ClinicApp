package com.clinicapp.users.impl.command.domain.doctor.factory;

import com.clinicapp.libs.constants.Role;
import com.clinicapp.users.api.command.definition.doctor.CreateDoctorCommand;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;
import com.clinicapp.users.impl.command.domain.PasswordGenerator;

import static com.clinicapp.libs.constants.Constants.DOCTOR_PERMISSIONS;
import static com.clinicapp.libs.constants.Constants.PASSWORD_LENGTH;

public class DoctorFactory {

    public static Doctor create(CreateDoctorCommand command) {

        Doctor doctor = new Doctor();

        //GENERAL INFO
        doctor.setFirstName(command.getFirstName());
        doctor.setFamilyName(command.getFamilyName());
        doctor.setSpecialization(command.getSpecialization());
        doctor.setWorkingHours(command.getWorkingHours());

        //ACCOUNT SETTINGS
        doctor.setEmail(command.getEmail());
        doctor.setLogin(command.getEmail());
        doctor.setPassword(PasswordGenerator.generate(PASSWORD_LENGTH));
        doctor.setRole(Role.DOCTOR);
        doctor.setCreationTime(System.currentTimeMillis());
        doctor.setPermissions(DOCTOR_PERMISSIONS);

        return doctor;
    }
}
