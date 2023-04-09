package com.springpractice.sbpetclinic.services.map;

import com.springpractice.sbpetclinic.model.Owner;
import com.springpractice.sbpetclinic.services.PetService;
import com.springpractice.sbpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceMapTest {

    @InjectMocks
    OwnerServiceMap ownerServiceMap;
    @Mock
    PetTypeService petTypeServiceMock;
    @Mock
    PetService petServiceMock;

    final Long ownerId1 = 1L;
    final Long ownerId2 = 2L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap.save(Owner.builder()
                .id(ownerId1)
                .lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId1);

        assertEquals(ownerId1, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner = Owner.builder().id(ownerId2).build();

        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(ownerId2, savedOwner.getId());
    }
    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();

        Owner savedOwner = ownerServiceMap.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId1));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId1);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }
    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("test");

        assertNull(owner);
    }
}