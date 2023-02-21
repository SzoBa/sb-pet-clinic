package com.springpractice.sbpetclinic.bootstrap;

import com.springpractice.sbpetclinic.model.*;
import com.springpractice.sbpetclinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    //when the app is up, then it will run

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) loadData();

    }

    private void loadData() {
        PetType dog = PetType.builder().name("Dog").build();
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = PetType.builder().name("Cat").build();
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = Speciality.builder().description("Radiology").build();
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = Speciality.builder().description("Surgery").build();
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = Speciality.builder().description("Dentistry").build();
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .address("123 Sthing")
                .city("Atlanta")
                .telephone("12345678").build();

        Pet mikesPet = Pet.builder()
                .petType(savedDogPetType)
                .owner(owner1)
                .birthDate(LocalDate.now())
                .name("Ubul").build();

        owner1.addPet(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = Owner.builder()
                .firstName("Fiona")
                .lastName("Glenanne")
                .address("456 Other")
                .city("Washington")
                .telephone("456789123").build();

        Pet fionasCat = Pet.builder()
                .petType(savedCatPetType)
                .owner(owner2)
                .birthDate(LocalDate.now())
                .name("Lucretia").build();

        owner2.addPet(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = Visit.builder()
                .pet(fionasCat)
                .date(LocalDate.now())
                .description("Sneezy kitty").build();

        visitService.save(catVisit);

        log.info("Loaded owners...");

        Vet vet1 = Vet.builder()
                .firstName("Sam")
                .lastName("Axe")
                .speciality(savedRadiology).build();

        vetService.save(vet1);

        Vet vet2 = Vet.builder()
                .firstName("Jessie")
                .lastName("Porter")
                .speciality(savedSurgery).build();

        vetService.save(vet2);
        log.info("Loaded vets...");
    }

}
