package com.clinicalapp.visits.api.command.handler;

import com.clinicalapp.visits.api.command.definition.CreateVisitCommand;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractCommandHandler;

import javax.ejb.Remote;
import java.util.UUID;

@Remote
public interface CreateVisitCommandHandler extends AbstractCommandHandler<UUID, CreateVisitCommand, ClinicAppException> {

    String jndi = "java:global/clinic-app-visits/CreateVisitCommandHandlerImpl!com.clinicalapp.visits.api.command.handler.CreateVisitCommandHandler";

}
