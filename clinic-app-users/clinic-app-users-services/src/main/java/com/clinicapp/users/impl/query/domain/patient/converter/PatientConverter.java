package com.clinicapp.users.impl.query.domain.patient.converter;

import com.clinicapp.users.api.query.definition.patient.result.GetPatientShortInfoByIdQueryResult;
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

    public static GetPatientShortInfoByIdQueryResult getPatientShortInfoByIdQueryResult(Patient patient) {

        GetPatientShortInfoByIdQueryResult queryResult = new GetPatientShortInfoByIdQueryResult();

        queryResult.setFirstName(patient.getFirstName());
        queryResult.setFamilyName(patient.getFamilyName());
        queryResult.setIdentificationNumberType("PESEL");
        queryResult.setIdentificationNumberValue(patient.getIdentificationNumber().getValue());

        return queryResult;
    }
}
