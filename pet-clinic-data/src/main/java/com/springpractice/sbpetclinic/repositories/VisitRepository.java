package com.springpractice.sbpetclinic.repositories;

import com.springpractice.sbpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
