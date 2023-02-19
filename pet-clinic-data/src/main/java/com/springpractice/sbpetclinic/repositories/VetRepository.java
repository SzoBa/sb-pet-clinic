package com.springpractice.sbpetclinic.repositories;

import com.springpractice.sbpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
