package com.springpractice.sbpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "specialties")
@EqualsAndHashCode(callSuper = true)
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
