package com.clinicapp.users.impl.startup;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.impl.command.datatypes.entity.identificationnumber.IdentificationNumberType;
import com.clinicapp.users.impl.command.repo.identificationnumber.IdentificationNumberTypeRepo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class UserStartupService {

    @EJB
    private IdentificationNumberTypeRepo identificationNumberTypeRepo;

    @PostConstruct
    public void init() {
        try {
            initializeIdentificationNumbers();
        } catch (ClinicAppException e) {
            System.out.println("-------------------------");
            System.out.println("INIT ERROR");
            System.out.println(e.getMessage());
            System.out.println("-------------------------");
        }
    }

    private void initializeIdentificationNumbers() throws ClinicAppException {
        IdentificationNumberType identificationNumberType = new IdentificationNumberType();

        identificationNumberType.setValue("PESEL");

        identificationNumberTypeRepo.create(identificationNumberType);
    }
}
