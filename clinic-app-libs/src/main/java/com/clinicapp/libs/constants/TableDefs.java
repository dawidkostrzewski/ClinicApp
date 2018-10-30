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
    }

    public class ColumnNames {

        public class BaseEntity {
            public static final String ID = "ID";
            public static final String CREATION_TIME = "CREATION_TIME";
        }
    }
}
