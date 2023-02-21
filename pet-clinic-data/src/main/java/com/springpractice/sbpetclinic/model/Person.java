package com.springpractice.sbpetclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Setter
@Getter
@SuperBuilder
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
