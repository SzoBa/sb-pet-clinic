package com.springpractice.sbpetclinic.repositories;

import com.springpractice.sbpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
