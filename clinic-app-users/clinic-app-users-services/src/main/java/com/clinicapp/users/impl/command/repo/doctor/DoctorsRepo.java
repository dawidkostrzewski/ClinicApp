package com.clinicapp.users.impl.command.repo.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import static com.clinicapp.users.impl.command.datatypes.QueryTokens.EMAIL;
import static com.clinicapp.users.impl.command.datatypes.QueryTokens.GET_DOCTOR_BY_EMAIL;

@Stateless
@LocalBean
public class DoctorsRepo extends AbstractRepo<Doctor> {


    public void checkDoctorEmailUnique(String email) throws ClinicAppException {

        Doctor doctor = getByNamedQuery(GET_DOCTOR_BY_EMAIL, EMAIL, email);

        if(doctor == null) {
            throw new ClinicAppException(ExceptionsTokens.EMAIL_ALREADY_TAKEN);
        }
    }
}
