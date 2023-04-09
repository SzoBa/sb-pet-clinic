package com.springpractice.sbpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "types")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

}
