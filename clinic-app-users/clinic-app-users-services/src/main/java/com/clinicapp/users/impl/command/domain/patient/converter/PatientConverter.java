package com.clinicapp.users.impl.command.domain.patient.converter;

import com.clinicapp.users.api.query.definition.patient.result.GetPatientsListElementQueryResult;
import com.clinicapp.users.api.query.definition.patient.result.GetPatientsListQueryResult;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientConverter {

    public static GetPatientsListQueryResult getPatientsListQueryResult(List<Patient> patients) {

        List<GetPatientsListElementQueryResult> list = new ArrayList<>();

        for(Patient patient : patients) {

            GetPatientsListElementQueryResult listElementQueryResult = new GetPatientsListElementQueryResult();

            listElementQueryResult.setId(patient.getId());
            listElementQueryResult.setBirthDate(patient.getBirthDate());
            listElementQueryResult.setIdentificationNumberType("PESEL");
            listElementQueryResult.setGetIdentificationNumberValue(patient.getIdentificationNumber().getValue());
            listElementQueryResult.setPhoneCC(patient.getPatientPhoneCC());
            listElementQueryResult.setPhone(patient.getPatientPhone());

            list.add(listElementQueryResult);
        }

        return new GetPatientsListQueryResult(list);
    }
}
