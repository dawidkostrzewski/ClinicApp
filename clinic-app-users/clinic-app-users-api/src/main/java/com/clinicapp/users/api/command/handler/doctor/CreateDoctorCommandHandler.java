package com.clinicapp.users.api.command.handler.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractCommandHandler;
import com.clinicapp.users.api.command.definition.doctor.CreateDoctorCommand;

import javax.ejb.Remote;
import java.util.UUID;

@Remote
public interface CreateDoctorCommandHandler extends AbstractCommandHandler<UUID, CreateDoctorCommand, ClinicAppException> {

    String jndi = "java:app/clinic-app-users/CreateDoctorCommandHandlerImpl!com.clinicapp.users.api.command.handler.doctor.CreateDoctorCommandHandler";

}
