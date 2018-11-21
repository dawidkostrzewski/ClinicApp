package com.clinicalapp.visits.impl.command.repo.visit;

import com.clinicalapp.visits.api.command.definition.CreateVisitCommand;
import com.clinicalapp.visits.impl.command.datatypes.QueryTokens;
import com.clinicalapp.visits.impl.command.datatypes.entity.Visit;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.exceptions.ExceptionsTokens;
import com.clinicapp.libs.repo.AbstractRepo;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class VisitRepo extends AbstractRepo<Visit> {

    @PersistenceContext(name = "public")
    private EntityManager entityManager;

    @PostConstruct
    private void init() {
        super.setEntityManager(entityManager);
    }

    public void checkVisitTimeIsAvailable(CreateVisitCommand command) throws ClinicAppException {

        List<String> paramsNames = new ArrayList<>();
        List<Object> paramsValues = new ArrayList<>();

        paramsNames.add(QueryTokens.PATIENT_ID);
        paramsNames.add(QueryTokens.VISIT_TIME);

        paramsValues.add(command.getPatientId());
        paramsValues.add(command.getVisitTime());

        Visit visit = getByNamedQuery(QueryTokens.CheckVisitTimeIsAvailable, paramsNames, paramsValues);

        if(visit != null) {
            throw new ClinicAppException(ExceptionsTokens.PATIENT_ALREADY_HAVE_VISIT_IN_THIS_TIME);
        }
    }
}
