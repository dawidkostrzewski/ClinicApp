package com.clinicapp.users.impl.command.repo.address;

import com.clinicapp.libs.repo.AbstractRepo;
import com.clinicapp.users.impl.command.datatypes.entity.address.Address;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AddressRepo extends AbstractRepo<Address> {

    @PersistenceContext(name = "public")
    private EntityManager entityManager;

    @PostConstruct
    private void init() {
        super.setEntityManager(entityManager);
    }
}
