package com.springpractice.sbpetclinic.services;

import com.springpractice.sbpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet pet);
    Set<Vet> findAll();

}
