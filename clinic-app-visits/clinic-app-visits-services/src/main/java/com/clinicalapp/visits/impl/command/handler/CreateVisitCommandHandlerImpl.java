package com.clinicalapp.visits.impl.command.handler;

import com.clinicalapp.visits.api.command.definition.CreateVisitCommand;
import com.clinicalapp.visits.api.command.handler.CreateVisitCommandHandler;
import com.clinicalapp.visits.impl.command.domain.factory.VisitFactory;
import com.clinicalapp.visits.impl.command.repo.visit.VisitRepo;
import com.clinicalapp.visits.impl.command.validation.CreateVisitCommandValidator;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.doctor.query.CheckIfDoctorExistQuery;
import com.clinicapp.users.api.query.definition.patient.query.CheckIfPatientExistQuery;
import com.clinicapp.users.api.query.handler.doctor.CheckIfDoctorExistQueryHandler;
import com.clinicapp.users.api.query.handler.patient.CheckIfPatientExistQueryHandler;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.UUID;

@Stateless
public class CreateVisitCommandHandlerImpl implements CreateVisitCommandHandler {

    @EJB
    private VisitRepo visitRepo;

    @Inject
    private CheckIfPatientExistQueryHandler checkIfPatientExistQueryHandler;

    @Inject
    private CheckIfDoctorExistQueryHandler checkIfDoctorExistQueryHandler;

    @Override
    public UUID handle(CreateVisitCommand command) throws ClinicAppException {

        CreateVisitCommandValidator.validate(command);

        checkIfDoctorExistQueryHandler.handle(new CheckIfDoctorExistQuery(command.getDoctorId()));

        checkIfPatientExistQueryHandler.handle(new CheckIfPatientExistQuery(command.getPatientId()));

        visitRepo.checkVisitTimeIsAvailableForPatient(command);

        visitRepo.checkVisitTimeIsAvailableForDoctor(command);

        return visitRepo.save(VisitFactory.create(command));
    }
}
