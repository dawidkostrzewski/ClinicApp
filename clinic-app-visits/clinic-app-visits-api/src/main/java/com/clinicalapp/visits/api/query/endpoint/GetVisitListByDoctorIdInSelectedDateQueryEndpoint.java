package com.clinicalapp.visits.api.query.endpoint;

import com.clinicalapp.visits.api.query.definition.query.GetVisitListByDoctorIdInSelectedDateQuery;
import com.clinicalapp.visits.api.query.handler.GetVisitListByDoctorIdInSelectedDateQueryHandler;
import com.clinicapp.libs.endpoints.AbstractEndpoint;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.ServiceProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static com.clinicalapp.visits.api.query.endpoint.GetVisitListByDoctorIdInSelectedDateQueryEndpoint.END_POINT_ADDRESS;

@Path(END_POINT_ADDRESS)
public class GetVisitListByDoctorIdInSelectedDateQueryEndpoint extends AbstractEndpoint {

    static final String END_POINT_ADDRESS = "/visit/list/";

    private static final String DOCTOR_ID = "doctorId";

    private static final String SELECTED_DATE = "selectedDate";

    private GetVisitListByDoctorIdInSelectedDateQueryHandler service(){
        return ServiceProvider.getService(GetVisitListByDoctorIdInSelectedDateQueryHandler.jndi);
    }

    @GET
    @Path("{" + DOCTOR_ID + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisitListByDoctorIdInSelectedDate(@PathParam(DOCTOR_ID)UUID doctorId,
                                                         @QueryParam(SELECTED_DATE) Long selectedDate) {
        try{
            return Response.status(Response.Status.OK).entity(service().handle(new GetVisitListByDoctorIdInSelectedDateQuery(doctorId, selectedDate))).build();
        } catch (ClinicAppException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
