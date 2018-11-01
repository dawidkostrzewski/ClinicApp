package com.clinicapp.libs.handler;


import java.io.Serializable;

public interface AbstractQueryHandler <T extends Serializable, W extends Serializable, E extends Throwable> {

    T handle(W command) throws E;

}
