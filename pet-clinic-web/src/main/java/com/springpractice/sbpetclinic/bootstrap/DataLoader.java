package com.springpractice.sbpetclinic.bootstrap;

import com.springpractice.sbpetclinic.model.Owner;
import com.springpractice.sbpetclinic.model.Vet;
import com.springpractice.sbpetclinic.services.OwnerService;
import com.springpractice.sbpetclinic.services.VetService;
import com.springpractice.sbpetclinic.services.map.OwnerServiceMap;
import com.springpractice.sbpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    //when the app is up, then it will run

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        
        vetService.save(vet1);
        
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        
        vetService.save(vet2);

        System.out.println("Loaded vets...");
        
    }

}
