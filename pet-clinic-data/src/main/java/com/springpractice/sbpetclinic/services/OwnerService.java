package com.springpractice.sbpetclinic.services;

import com.springpractice.sbpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
