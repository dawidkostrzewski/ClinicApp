package com.clinicapp.users.impl.query.handlers.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientsListQuery;
import com.clinicapp.users.api.query.definition.patient.result.GetPatientsListQueryResult;
import com.clinicapp.users.api.query.handler.patient.GetPatientsListQueryHandler;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;
import com.clinicapp.users.impl.query.domain.patient.converter.PatientConverter;
import com.clinicapp.users.impl.command.repo.patient.PatientsRepo;
import com.clinicapp.users.impl.query.validation.patient.GetPatientListQueryValidator;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GetPatientsListQueryHandlerImpl implements GetPatientsListQueryHandler {

    @EJB
    private PatientsRepo patientsRepo;

    @Override
    public GetPatientsListQueryResult handle(GetPatientsListQuery query) throws ClinicAppException {

        GetPatientListQueryValidator.validate(query);

        List<Patient> patients = patientsRepo.getPatientList(query);

        return PatientConverter.getPatientsListQueryResult(patients);
    }
}
