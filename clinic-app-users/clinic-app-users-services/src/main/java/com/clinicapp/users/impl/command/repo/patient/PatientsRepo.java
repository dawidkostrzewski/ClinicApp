package com.clinicapp.users.impl.command.repo.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientsListQuery;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.clinicapp.users.impl.command.datatypes.QueryTokens.*;

@Stateless
@LocalBean
public class PatientsRepo extends AbstractRepo<Patient> {

    @PersistenceContext(name = "public")
    private EntityManager usersEntityManager;

    @PostConstruct
    private void init() {
        super.setEntityManager(usersEntityManager);
    }

    public void checkPatientUniqueFields(String identificationNumberValue, String email) throws ClinicAppException {

        List<String> paramsNames = new ArrayList<>();
        paramsNames.add(IDENTIFICATION_NUMBER_VALUE);
        paramsNames.add(EMAIL);

        List<Object> paramsValues = new ArrayList<>();
        paramsValues.add(identificationNumberValue);
        paramsValues.add(email);


        Patient patient = getByNamedQuery(CHECK_PATIENT_UNIQUE_FIELDS, paramsNames, paramsValues);

        if(patient != null) {
            throw new ClinicAppException(ExceptionsTokens.IDENTIFICATION_NUMBER_UNIQUE_FALIED);
        }
    }

    public List<Patient> getPatientList(GetPatientsListQuery query) throws ClinicAppException {

        if(query.getDoctorId() != null) {
            return getRangeByNamedQueryWithSingleParameter(
                    GET_PATIENTS_LIST_BY_DOCTOR_ID, DOCTOR_ID, query.getDoctorId(), query.getLimit(), query.getOffset());
        }

        return getRangeByNamedQueryWithoutParameters(GET_PATIENTS_LIST, query.getLimit(), query.getOffset());
    }
}
