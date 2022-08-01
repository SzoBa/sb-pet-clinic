package com.springpractice.sbpetclinic.services;

import com.springpractice.sbpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
