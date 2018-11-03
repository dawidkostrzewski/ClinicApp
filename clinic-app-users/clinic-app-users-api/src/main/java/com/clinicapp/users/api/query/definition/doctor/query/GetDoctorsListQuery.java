package com.clinicapp.users.api.query.definition.doctor.query;

import java.io.Serializable;

public class GetDoctorsListQuery implements Serializable {

    private int offset;

    private int limit;

    public GetDoctorsListQuery(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
