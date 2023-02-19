package com.springpractice.sbpetclinic.services.map;

import com.springpractice.sbpetclinic.model.Speciality;
import com.springpractice.sbpetclinic.model.Vet;
import com.springpractice.sbpetclinic.services.SpecialityService;
import com.springpractice.sbpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
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

        if (0 <object.getSpecialities().size()) {
            object.getSpecialities().forEach(spec -> {
                if (spec.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(spec);
                    spec.setId(savedSpeciality.getId());
                }
            });

        }
        super.save(object);
        return object;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
