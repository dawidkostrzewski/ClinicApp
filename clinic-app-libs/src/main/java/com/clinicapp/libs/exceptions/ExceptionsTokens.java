package com.clinicapp.libs.exceptions;

public class ExceptionsTokens {

    public final static String INVALID_PARAMS_NUMBER = "Invalid params number";
    public final static String INVALID_PARAM = "Invalid param";
    public final static String ENTITY_NOT_FOUND =  "Entity not found";
    public final static String CREATE_ERROR = "Failed to add entity";
    public final static String UPDATE_ERROR = "Failed to update entity";
    public final static String REMOVE_ERROR = "Failed to remove entity";

    public final static String ERROR_WITH_QUERY = "Error while executing query";

    public final static String MISSING_DOCTOR_ID = "Missing doctor ID";
    public final static String MISSING_PATIENT_ID = "Missing patient ID";
    public final static String DOCTOR_NOT_EXIST = "Doctor with this ID not exist";
    public final static String PATIENT_NOT_EXIST = "Patient with this ID not exist";

    public final static String EMPTY_COMMAND = "Empty command";
    public final static String EMPTY_QUERY = "Empty query";

    public final static String MISSING_EMAIL = "Missing user e-mail";
    public final static String MISSING_DOCTOR_WORK_HOURS = "Missing doctor work hours";
    public final static String MISSING_FIRST_NAME = "Missing user first name";
    public final static String MISSING_FAMILY_NAME = "Missing user family name";
    public final static String MISSING_PATIENT_BASIC_INFO = "Missing patient basic info";
    public final static String MISSING_PATIENT_ADDRESS_INFO = "Missing patient address info";
    public final static String MISSING_PATIENT_CONTACT_INFO = "Missing patient contact info";


    public static final String EMAIL_ALREADY_TAKEN = "E-mail is already taken";
    public static final String IDENTIFICATION_NUMBER_UNIQUE_FALIED = "Patient with this identification number exist";

    public static final String MISSING_VISIT_TIME = "Missing visit time";
    public static final String PATIENT_ALREADY_HAVE_VISIT_IN_THIS_TIME = "Patient already have visit in this time";
}
