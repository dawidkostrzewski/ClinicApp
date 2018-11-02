package com.clinicapp.users.impl.command.repo.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import static com.clinicapp.users.impl.command.datatypes.QueryTokens.GET_PATIENT_BY_IDENTIFICATION_NUMBER_VALUE;
import static com.clinicapp.users.impl.command.datatypes.QueryTokens.IDENTIFICATION_NUMBER_VALUE;

@Stateless
@LocalBean
public class PatientsRepo extends AbstractRepo<Patient> {

    public void checkPatientIdentificationNumberUnique(String indetificationNumberValue) throws ClinicAppException {

        Patient patient = getByNamedQuery(GET_PATIENT_BY_IDENTIFICATION_NUMBER_VALUE, IDENTIFICATION_NUMBER_VALUE, indetificationNumberValue);

        if(patient == null) {
            throw new ClinicAppException(ExceptionsTokens.IDENTIFICATION_NUMBER_UNIQUE_FALIED);
        }
    }
}
