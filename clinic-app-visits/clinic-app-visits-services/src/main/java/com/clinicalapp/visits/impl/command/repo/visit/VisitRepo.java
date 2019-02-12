package com.clinicalapp.visits.impl.command.repo.visit;

import com.clinicalapp.visits.api.command.definition.CreateVisitCommand;
import com.clinicalapp.visits.impl.command.datatypes.QueryTokens;
import com.clinicalapp.visits.impl.command.datatypes.entity.Visit;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.libs.repo.AbstractRepo;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Stateless
@LocalBean
public class VisitRepo extends AbstractRepo<Visit> {

    @PersistenceContext(name = "public")
    private EntityManager entityManager;

    @PostConstruct
    private void init() {
        super.setEntityManager(entityManager);
    }

    public void checkVisitTimeIsAvailableForPatient(CreateVisitCommand command) throws ClinicAppException {

        List<String> paramsNames = new ArrayList<>();
        List<Object> paramsValues = new ArrayList<>();

        paramsNames.add(QueryTokens.PATIENT_ID);
        paramsNames.add(QueryTokens.VISIT_TIME);

        paramsValues.add(command.getPatientId());
        paramsValues.add(command.getVisitTime());

        Visit visit = getByNamedQuery(QueryTokens.CheckVisitTimeIsAvailableForPatient, paramsNames, paramsValues);

        if(visit != null) {
            throw new ClinicAppException(ExceptionsTokens.PATIENT_ALREADY_HAVE_VISIT_IN_THIS_TIME);
        }
    }

    public void checkVisitTimeIsAvailableForDoctor(CreateVisitCommand command) throws ClinicAppException {
        List<String> paramsNames = new ArrayList<>();
        List<Object> paramsValues = new ArrayList<>();

        paramsNames.add(QueryTokens.DOCTOR_ID);
        paramsNames.add(QueryTokens.VISIT_TIME);

        paramsValues.add(command.getPatientId());
        paramsValues.add(command.getVisitTime());

        Visit visit = getByNamedQuery(QueryTokens.CheckVisitTimeIsAvailableForDoctor, paramsNames, paramsValues);

        if(visit != null) {
            throw new ClinicAppException(ExceptionsTokens.DOCTOR_ALREADY_HAVE_VISIT_IN_THIS_TIME);
        }
    }

    public List<Visit> getAllVisitsForSelectedDate(UUID patientId, UUID doctorId, Long startTime, Long endTime) throws ClinicAppException {
        List<String> paramsNames = new ArrayList<>();
        List<Object> paramsValues = new ArrayList<>();

        paramsNames.add(QueryTokens.DOCTOR_ID);
        paramsNames.add(QueryTokens.PATIENT_ID);
        paramsNames.add(QueryTokens.START_TIME);
        paramsNames.add(QueryTokens.END_TIME);

        paramsValues.add(doctorId);
        paramsValues.add(patientId);
        paramsValues.add(startTime);
        paramsValues.add(endTime);

        return getRangeByNamedQuery(QueryTokens.GET_VISITS_IN_SELECTED_DATE_FOR_PATIENT_AND_DOCTOR, paramsNames, paramsValues);
    }

    public List<Visit> getAllDoctorVisitInSelectedDate(UUID doctorId, Long startTime, Long endTime) throws ClinicAppException {
        List<String> paramsNames = new ArrayList<>();
        List<Object> paramsValues = new ArrayList<>();

        paramsNames.add(QueryTokens.DOCTOR_ID);
        paramsNames.add(QueryTokens.START_TIME);
        paramsNames.add(QueryTokens.END_TIME);

        paramsValues.add(doctorId);
        paramsValues.add(startTime);
        paramsValues.add(endTime);

        return getRangeByNamedQuery(QueryTokens.GET_DOCTOR_VISITS_IN_SELECTED_DATE, paramsNames, paramsValues);
    }
}
