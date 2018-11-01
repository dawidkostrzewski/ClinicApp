package com.clinicapp.users.impl.command.repo.doctor;

import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class DoctorsRepo extends AbstractRepo<Doctor> {
}
