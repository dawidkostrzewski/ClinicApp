package com.clinicapp.users.impl.command.domain.patient.factory;

import com.clinicapp.users.api.command.definition.patient.CreatePatientCommand;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;

public class PatientFactory {

    public static Patient create(CreatePatientCommand command) {
        return new Patient();
    }
}
