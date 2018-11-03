package com.clinicapp.users.api.query.endpoint.doctor;

import com.clinicapp.libs.endpoints.AbstractEndpoint;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorsListQuery;
import com.clinicapp.users.api.query.handler.doctor.GetDoctorsListQueryHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.clinicapp.users.api.query.endpoint.doctor.GetDoctorsListQueryEndpoint.END_POINT_ADDRESS;

@Path(END_POINT_ADDRESS)
public class GetDoctorsListQueryEndpoint extends AbstractEndpoint {

    static final String END_POINT_ADDRESS = "/doctors";

    private GetDoctorsListQueryHandler service() {
        return getService(GetDoctorsListQueryHandler.jndi);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorsList(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        try {
            return Response.status(Response.Status.OK).entity(service().handle(new GetDoctorsListQuery(limit, offset))).build();
        } catch (ClinicAppException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
