package com.clinicalapp.visits.api.query.definition.result;


import java.io.Serializable;
import java.util.List;

public class GetVisitsForSelectedDateQueryResult implements Serializable {

    private List<GetVisitsForSelectedDateItemQueryResult> list;

    public List<GetVisitsForSelectedDateItemQueryResult> getList() {
        return list;
    }

    public void setList(List<GetVisitsForSelectedDateItemQueryResult> list) {
        this.list = list;
    }

    public GetVisitsForSelectedDateQueryResult() {
    }
}
