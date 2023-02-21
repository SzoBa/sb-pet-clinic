package com.springpractice.sbpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "types")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

}
