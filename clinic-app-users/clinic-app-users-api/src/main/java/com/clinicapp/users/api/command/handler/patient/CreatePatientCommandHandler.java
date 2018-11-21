package com.clinicapp.users.api.command.handler.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractCommandHandler;
import com.clinicapp.users.api.command.definition.patient.CreatePatientCommand;

import javax.ejb.Remote;
import java.util.UUID;


@Remote
public interface CreatePatientCommandHandler extends AbstractCommandHandler<UUID, CreatePatientCommand, ClinicAppException> {

    String jndi = "java:global/clinic-app-users/CreatePatientCommandHandlerImpl!com.clinicapp.users.api.command.handler.patient.CreatePatientCommandHandler";
}
