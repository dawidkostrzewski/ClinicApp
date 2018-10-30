package com.clinicapp.libs.exceptions;

public class ExceptionsTokens {

    public final static String INVALID_PARAMS_NUMBER = "Invalid params number";
    public final static String INVALID_PARAM = "Invalid param";
    public final static String ENTITY_NOT_FOUND =  "Entity not found";
    public final static String CREATE_ERROR = "Failed to add entity";
    public final static String UPDATE_ERROR = "Failed to update entity";
    public final static String REMOVE_ERROR = "Failed to remove entity";

    public final static String ERROR_WITH_QUERY = "Error while executing query";
    public final static String ERROR_WHILE_PARSE_WORK_HOURS = "Error while parse working hours";

    public final static String MISSING_DOCTOR_ID = "Missing doctor ID";
    public final static String MISSING_PATIENT_ID = "Missing patient ID";
    public final static String DOCTOR_NOT_EXIST = "Doctor with this ID not exist";
    public final static String PATIENT_NOT_EXIST = "Patient with this ID not exist";
    public final static String MISSING_MEDICAL_SERVICE_ID = "Medical service with this ID not exist";
    public final static String MISSING_EXAMINATION_DEFINITION_ID = "Examination definition with this ID not exist";

    public final static String EMPTY_COMMAND = "Empty command";
    public final static String EMPTY_EVENT = "Empty event";
    public final static String EMPTY_QUERY = "Empty query";

    public final static String MEDICAL_SERVICE_ACTIVE = "Patient have active service";
    public final static String MISSING_ACTIVE_MEDICAL_SERVICE = "Patient don't have active medical service";
    public final static String MISSING_EXAMINATION_FREQUENCY = "Missing examination frequency";
    public final static String MISSING_EXAMINATION_THRESHOLDS = "Missing examination thresholds";

    public final static String MEDICAL_SERVICE_CONTAINS_THIS_EXAMINATION_TYPE = "Medical service contains this type of examination";

    public final static String PATIENT_ALREADY_HAVE_DEVICE = "Patient already have registered device";
    public final static String MISSING_DEVICE_ID = "Missing device ID";

    public final static String MISSING_USER_LOGIN = "Missing user login";
    public final static String MISSING_EMPLOYEE_ROLE = "Missing user role";
}
