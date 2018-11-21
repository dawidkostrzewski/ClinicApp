package com.clinicalapp.visits.api.command.endpoint;

import com.clinicalapp.visits.api.command.definition.CreateVisitCommand;
import com.clinicalapp.visits.api.command.handler.CreateVisitCommandHandler;
import com.clinicapp.libs.endpoints.AbstractEndpoint;
import com.clinicapp.libs.exceptions.ClinicAppException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.clinicalapp.visits.api.command.endpoint.CreateVisitCommandEndpoint.END_POINT_ADDRESS;

@Path(END_POINT_ADDRESS)
public class CreateVisitCommandEndpoint extends AbstractEndpoint {

    static final String END_POINT_ADDRESS = "/visit/create";

    private CreateVisitCommandHandler service() {
        return getService(CreateVisitCommandHandler.jndi);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createVisit(CreateVisitCommand command) {
        try {
            return Response.status(Response.Status.OK).entity(service().handle(command)).build();
        } catch (ClinicAppException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
