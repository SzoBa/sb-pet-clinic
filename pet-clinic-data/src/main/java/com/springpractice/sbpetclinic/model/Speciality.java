package com.springpractice.sbpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@SuperBuilder
@Table(name = "specialties")
@EqualsAndHashCode(callSuper = true)
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
