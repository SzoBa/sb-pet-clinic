package com.springpractice.sbpetclinic.repositories;

import com.springpractice.sbpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
