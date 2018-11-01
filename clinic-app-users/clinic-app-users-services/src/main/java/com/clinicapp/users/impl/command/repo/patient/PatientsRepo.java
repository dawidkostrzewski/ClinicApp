package com.clinicapp.users.impl.command.repo.patient;

import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class PatientsRepo extends AbstractRepo<Patient> {
}
