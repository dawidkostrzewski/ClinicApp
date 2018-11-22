package com.clinicapp.libs.constants;


public class TableDefs {

    public static final String SCHEMA_NAME = "public";
    public static final String CATALOG_NAME = "medcare";

    public class TablesNames {
        public static final String PATIENTS = "PATIENTS";
        public static final String DOCTORS = "DOCTORS";
        public static final String RECEPTIONIST = "RECEPTIONIST";
        public static final String ADMINISTRATOR = "ADMINISTRATOR";
        public static final String USERS = "USERS";

        public static final String MEDICINES = "MEDICINES";
        public static final String VISIT = "VISIT";
        public static final String PERMISSION = "PERMISSIONS";
        public static final String IDENTIFICATION_NUMBER_TYPE = "IDENTIFICATION_NUMBER_TYPE";
        public static final String IDENTIFICATION_NUMBER = "IDENTIFICATION_NUMBER";
        public static final String ADDRESS = "ADDRESS";

        public static final String WORK_TIME = "WORK_TIME";
        public static final String WORK_DAY = "WORK_DAY";
        public static final String WORKING_HOURS = "WORKING_HOURS";
    }


    public class ColumnNames {

        public static final String PATIENT_ID = "PATIENT_ID";
        public static final String DOCTOR_ID = "DOCTOR_ID";


        public class BaseEntity {
            public static final String ID = "ID";
            public static final String CREATION_TIME = "CREATION_TIME";
        }

        public class User {
            public static final String FIRST_NAME = "FIRST_NAME";
            public static final String FAMILY_NAME = "FAMILY_NAME";
            public static final String BIRTH_DATE = "BIRTH_DATE";
            public static final String LOGIN = "LOGIN";
            public static final String PASSWORD = "PASSWORD";
            public static final String SEX = "SEX";
            public static final String EMAIL = "EMAIL";
            public static final String ROLE = "ROLE";
        }

        public class Patient {
            public static final String IDENTIFICATION_NUMBER_TYPE = "IDENTIFICATION_NUMBER_TYPE";
            public static final String IDENTIFICATION_NUMBER = "IDENTIFICATION_NUMBER";
            public static final String CONTACT_PHONE_CC = "CONTACT_PHONE_CC";
            public static final String PATIENT_PHONE_CC = "PATIENT_PHONE_CC";
            public static final String CONTACT_PHONE = "CONTACT_PHONE";
            public static final String PATIENT_PHONE = "PATIENT_PHONE";
        }

        public class Doctor {
            public static final String SPECIALIZATION = "SPECIALIZATION";
            public static final String WORKING_HOURS = "WORKING_HOURS";
        }

        public class Permission {
            public static final String VALUE = "VALUE";
            public static final String DESCRIPTION = "DESCRIPTION";
        }

        public class IdentificationNumberType {
            public static final String VALUE = "VALUE";
            public static final String VALIDATOR = "VALIDATOR";
        }

        public class IdentificationNumber {
            public static final String VALUE = "VALUE";
            public static final String TYPE = "TYPE";
        }

        public class Address {
            public static final String CITY = "CITY";
            public static final String STREET = "STREET";
            public static final String HOUSE_NUBER = "HOUSE_NUMBER";
            public static final String FLAT_NUMBER = "FLAT_NUMBER";
        }

        public class Visit {
            public static final String DOCTOR = "DOCTOR";
            public static final String PATIENT = "PATIENT";
            public static final String TIME = "TIME";
            public static final String DESCRIPTION = "DESCRIPTION";
            public static final String FINISHED = "FINISHED";
        }

        public class WorkTime {
            public static final String HOURS = "HOURS";
            public static final String MINUTES = "MINUTES";
        }
    }
}
