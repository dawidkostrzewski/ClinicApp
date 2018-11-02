package com.clinicapp.users.api.command.endpoint.patient;

import com.clinicapp.libs.endpoints.AbstractEndpoint;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.command.definition.patient.CreatePatientCommand;
import com.clinicapp.users.api.command.handler.patient.CreatePatientCommandHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.clinicapp.users.api.command.endpoint.patient.CreatePatientCommandEndpoint.END_POINT_ADDRESS;

@Path(END_POINT_ADDRESS)
public class CreatePatientCommandEndpoint extends AbstractEndpoint {

    static final String END_POINT_ADDRESS = "/patients/create";

    private CreatePatientCommandHandler service() {
        return getService(CreatePatientCommandHandler.jndi);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPatient(CreatePatientCommand command) {
        try{
          return Response.status(Response.Status.OK).entity(service().handle(command)).build();
        } catch (ClinicAppException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
