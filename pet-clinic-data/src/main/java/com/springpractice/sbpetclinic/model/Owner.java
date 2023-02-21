package com.springpractice.sbpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "owners")
@EqualsAndHashCode(callSuper = true)
public class Owner extends Person {

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public void addPet(Pet pet) {
        pets.add(pet);
    }

}



