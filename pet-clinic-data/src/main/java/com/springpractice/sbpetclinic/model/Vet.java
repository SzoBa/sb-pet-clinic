package com.springpractice.sbpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@Table(name = "vets")
@EqualsAndHashCode(callSuper = true)
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
        inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    @Singular private Set<Speciality> specialities = new HashSet<>();

}
