package com.clinicapp.libs.constants;

import java.util.HashSet;
import java.util.Set;

public class Constants {

    public final static int LIMIT = 15;
    public final static int DEFAULT_OFFSET = 0;
    public final static int SEARCH_LIMIT = 15;
    public final static int PASSWORD_LENGTH = 8;

    //ROLES PERMISSIONS
    public final static Set<String> PATIENT_PERMISSIONS = new HashSet<>();
    public final static Set<String> DOCTOR_PERMISSIONS = new HashSet<>();
}
