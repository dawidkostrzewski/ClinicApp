package com.clinicalapp.visits.api.query.endpoint;


import com.clinicalapp.visits.api.query.definition.query.GetAvailableVisitTimesByDoctorAndPatientIdQuery;
import com.clinicalapp.visits.api.query.handler.GetAvailableVisitTimesByDoctorAndPatientIdQueryHandler;
import com.clinicapp.libs.endpoints.AbstractEndpoint;
import com.clinicapp.libs.exceptions.ClinicAppException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static com.clinicalapp.visits.api.query.endpoint.GetAvailableVisitTimesByDoctorAndPatientIdQueryEndpoint.END_POINT_ADDRESS;

@Path(END_POINT_ADDRESS)
public class GetAvailableVisitTimesByDoctorAndPatientIdQueryEndpoint extends AbstractEndpoint {

    static final String END_POINT_ADDRESS = "/visits/available";

    private static final String PATIENT_ID = "patientId";

    private static final String DOCTOR_ID = "doctorId";

    private static final String SELECTED_DATE = "selectedDate";

    private GetAvailableVisitTimesByDoctorAndPatientIdQueryHandler service() {
        return getService(GetAvailableVisitTimesByDoctorAndPatientIdQueryHandler.jndi);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableVisitTimesByDoctorAndPatientId(@QueryParam(PATIENT_ID) UUID patientId,
                                                               @QueryParam(DOCTOR_ID) UUID doctorId,
                                                               @QueryParam(SELECTED_DATE) Long selectedDate) {
        try {
            return Response.status(Response.Status.OK)
                    .entity(service()
                            .handle(new GetAvailableVisitTimesByDoctorAndPatientIdQuery(patientId, doctorId, selectedDate))).build();
        } catch (ClinicAppException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

}
