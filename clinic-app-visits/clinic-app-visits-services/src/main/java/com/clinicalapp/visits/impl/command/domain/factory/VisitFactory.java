package com.clinicalapp.visits.impl.command.domain.factory;

import com.clinicalapp.visits.api.command.definition.CreateVisitCommand;
import com.clinicalapp.visits.impl.command.datatypes.entity.Visit;

public class VisitFactory {

    public static Visit create(CreateVisitCommand command) {

        Visit visit = new Visit();

        visit.setDoctor(command.getDoctorId());
        visit.setPatient(command.getPatientId());
        visit.setTime(command.getVisitTime());
        visit.setFinished(false);
        visit.setDescription(command.getDescription());
        visit.setCreationTime(System.currentTimeMillis());

        return visit;
    }
}
