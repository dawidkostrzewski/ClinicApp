package com.clinicapp.users.impl.query.domain.doctor.converter;

import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorListElementQueryResult;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorsListQueryResult;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorConverter {

    public static GetDoctorsListQueryResult convertToDoctorsList(List<Doctor> doctors) {


        List<GetDoctorListElementQueryResult> getDoctorsListQueryResultList = new ArrayList<>();

        for(Doctor doctor : doctors) {
            GetDoctorListElementQueryResult element = new GetDoctorListElementQueryResult();

            element.setId(doctor.getId());
            element.setName(doctor.getFamilyName() + " " + doctor.getFirstName());
            element.setSpecialization(doctor.getSpecialization());

            getDoctorsListQueryResultList.add(element);
        }

        return new GetDoctorsListQueryResult(getDoctorsListQueryResultList);
    }
}
