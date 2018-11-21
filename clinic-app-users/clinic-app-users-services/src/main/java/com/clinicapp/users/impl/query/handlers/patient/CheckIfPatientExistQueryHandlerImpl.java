package com.clinicapp.users.impl.query.handlers.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractHandler;
import com.clinicapp.users.api.query.definition.patient.query.CheckIfPatientExistQuery;
import com.clinicapp.users.api.query.handler.patient.CheckIfPatientExistQueryHandler;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;
import com.clinicapp.users.impl.command.repo.patient.PatientsRepo;
import com.clinicapp.users.impl.query.validation.patient.CheckIfPatientExistQueryValidator;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CheckIfPatientExistQueryHandlerImpl extends AbstractHandler<Patient> implements CheckIfPatientExistQueryHandler {

    @EJB
    private PatientsRepo patientsRepo;

    @Override
    public Boolean handle(CheckIfPatientExistQuery query) throws ClinicAppException {

        CheckIfPatientExistQueryValidator.validate(query);

        Patient patient = patientsRepo.getById(query.getPatientId());

        return patient != null;
    }
}
