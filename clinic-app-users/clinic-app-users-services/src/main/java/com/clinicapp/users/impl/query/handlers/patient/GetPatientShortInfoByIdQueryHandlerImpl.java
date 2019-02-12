package com.clinicapp.users.impl.query.handlers.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractHandler;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientShortInfoByIdQuery;
import com.clinicapp.users.api.query.definition.patient.result.GetPatientShortInfoByIdQueryResult;
import com.clinicapp.users.api.query.handler.patient.GetPatientShortInfoByIdQueryHandler;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;
import com.clinicapp.users.impl.command.repo.patient.PatientsRepo;
import com.clinicapp.users.impl.query.domain.patient.converter.PatientConverter;
import com.clinicapp.users.impl.query.validation.patient.GetPatientShortInfoByIdQueryValidation;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GetPatientShortInfoByIdQueryHandlerImpl extends AbstractHandler<Patient> implements GetPatientShortInfoByIdQueryHandler {

    @EJB
    private PatientsRepo patientsRepo;

    @Override
    public GetPatientShortInfoByIdQueryResult handle(GetPatientShortInfoByIdQuery query) throws ClinicAppException {

        GetPatientShortInfoByIdQueryValidation.validate(query);

        Patient patient = patientsRepo.getById(query.getPatientId());

        checkIfExist(patient);

        return PatientConverter.getPatientShortInfoByIdQueryResult(patient);
    }
}
