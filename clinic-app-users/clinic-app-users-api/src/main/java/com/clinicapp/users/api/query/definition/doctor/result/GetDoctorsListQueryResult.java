package com.clinicapp.users.api.query.definition.doctor.result;

import java.io.Serializable;
import java.util.List;

public class GetDoctorsListQueryResult implements Serializable {

    private List<GetDoctorListElementQueryResult> list;

    public GetDoctorsListQueryResult(List<GetDoctorListElementQueryResult> list) {
        this.list = list;
    }

    public List<GetDoctorListElementQueryResult> getList() {
        return list;
    }

    public void setList(List<GetDoctorListElementQueryResult> list) {
        this.list = list;
    }
}
