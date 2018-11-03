package com.clinicapp.users.api.query.definition.patient.result;

import java.io.Serializable;
import java.util.List;

public class GetPatientsListQueryResult implements Serializable {

    private List<GetPatientsListElementQueryResult> list;

    public GetPatientsListQueryResult(List<GetPatientsListElementQueryResult> list) {
        this.list = list;
    }

    public List<GetPatientsListElementQueryResult> getList() {
        return list;
    }

    public void setList(List<GetPatientsListElementQueryResult> list) {
        this.list = list;
    }
}
