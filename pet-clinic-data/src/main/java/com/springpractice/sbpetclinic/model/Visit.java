package com.springpractice.sbpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "visits")
@EqualsAndHashCode(callSuper = true)
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
