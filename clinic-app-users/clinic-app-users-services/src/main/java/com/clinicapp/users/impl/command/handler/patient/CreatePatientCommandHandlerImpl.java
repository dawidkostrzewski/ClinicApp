package com.clinicapp.users.impl.command.handler.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.command.definition.patient.CreatePatientCommand;
import com.clinicapp.users.api.command.handler.patient.CreatePatientCommandHandler;
import com.clinicapp.users.api.query.definition.doctor.query.CheckIfDoctorExistQuery;
import com.clinicapp.users.api.query.handler.doctor.CheckIfDoctorExistQueryHandler;
import com.clinicapp.users.impl.command.domain.patient.factory.PatientFactory;
import com.clinicapp.users.impl.command.repo.patient.PatientsRepo;
import com.clinicapp.users.impl.command.validation.patient.CreatePatientCommandValidator;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.UUID;

@Stateless
public class CreatePatientCommandHandlerImpl implements CreatePatientCommandHandler {

    @EJB
    private PatientsRepo patientsRepo;

    @EJB
    private CheckIfDoctorExistQueryHandler checkIfDoctorExistQueryHandler;

    @Override
    public UUID handle(CreatePatientCommand command) throws ClinicAppException {

        CreatePatientCommandValidator.validate(command);

        checkIfDoctorExistQueryHandler.handle(new CheckIfDoctorExistQuery(command.getDoctorId()));

        patientsRepo.checkPatientUniqueFields(command.getIdentificationNumberValue(), command.getEmail());

        return patientsRepo.save(PatientFactory.create(command));
    }
}
