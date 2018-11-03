package com.clinicapp.users.impl.command.repo.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.clinicapp.users.impl.command.datatypes.QueryTokens.GET_PATIENT_BY_IDENTIFICATION_NUMBER_VALUE;
import static com.clinicapp.users.impl.command.datatypes.QueryTokens.IDENTIFICATION_NUMBER_VALUE;

@Stateless
@LocalBean
public class PatientsRepo extends AbstractRepo<Patient> {

    @PersistenceContext(name = "public")
    private EntityManager usersEntityManager;

    @PostConstruct
    private void init() {
        super.setEntityManager(usersEntityManager);
    }

    public void checkPatientIdentificationNumberUnique(String identificationNumberValue) throws ClinicAppException {

        Patient patient = getByNamedQuery(GET_PATIENT_BY_IDENTIFICATION_NUMBER_VALUE, IDENTIFICATION_NUMBER_VALUE, identificationNumberValue);

        if(patient != null) {
            throw new ClinicAppException(ExceptionsTokens.IDENTIFICATION_NUMBER_UNIQUE_FALIED);
        }
    }
}
