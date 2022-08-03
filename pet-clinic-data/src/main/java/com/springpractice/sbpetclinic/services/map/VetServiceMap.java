package com.springpractice.sbpetclinic.services.map;

import com.springpractice.sbpetclinic.model.Vet;
import com.springpractice.sbpetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findall();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        super.save(object.getId(), object);
        return object;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}