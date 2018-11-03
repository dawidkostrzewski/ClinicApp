package com.clinicapp.users.api.query.endpoint.patient;

import com.clinicapp.libs.endpoints.AbstractEndpoint;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientsListQuery;
import com.clinicapp.users.api.query.handler.patient.GetPatientsListQueryHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static com.clinicapp.users.api.query.endpoint.patient.GetPatientsListQueryEnpoint.END_POINT_ADDRESS;

@Path(END_POINT_ADDRESS)
public class GetPatientsListQueryEnpoint extends AbstractEndpoint {

    static final String END_POINT_ADDRESS = "/patients";

    private GetPatientsListQueryHandler service() {
        return getService(GetPatientsListQueryHandler.jndi);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientsList(
            @QueryParam("doctorId") UUID doctorId,
            @QueryParam("limit") int limit,
            @QueryParam("offset") int offset) {
        try {
            return Response.status(Response.Status.OK)
                    .entity(service().handle(new GetPatientsListQuery(doctorId, limit, offset))).build();
        } catch (ClinicAppException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
