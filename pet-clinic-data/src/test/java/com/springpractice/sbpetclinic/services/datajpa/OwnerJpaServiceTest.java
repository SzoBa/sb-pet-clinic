package com.springpractice.sbpetclinic.services.datajpa;

import com.springpractice.sbpetclinic.model.Owner;
import com.springpractice.sbpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @InjectMocks
    OwnerJpaService ownerJpaService;
    @Mock
    OwnerRepository ownerRepositoryMock;
    @Captor
    ArgumentCaptor<String> stringCaptor;
    @Captor
    ArgumentCaptor<Long> longCaptor;
    @Captor
    ArgumentCaptor<Owner> ownerCaptor;
    final Long OWNER_ID = 1L;
    final String LAST_NAME = "Smith";
    Owner owner;
    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepositoryMock.findByLastName(anyString())).thenReturn(owner);
        Owner smith = ownerJpaService.findByLastName(LAST_NAME);

        verify(ownerRepositoryMock).findByLastName(stringCaptor.capture());
        assertEquals(owner.getLastName(), stringCaptor.getValue());
        assertEquals(owner, smith);
    }

    @Test
    void findAll() {
        Owner owner2 = Owner.builder().id(2L).build();
        Set<Owner> returnOwners = Set.of(owner, owner2);

        when(ownerRepositoryMock.findAll()).thenReturn(returnOwners);
        Set<Owner> owners = ownerJpaService.findAll();

        verify(ownerRepositoryMock).findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepositoryMock.findById(anyLong())).thenReturn(Optional.ofNullable(owner));
        Owner ownerById = ownerJpaService.findById(OWNER_ID);

        verify(ownerRepositoryMock).findById(longCaptor.capture());
        assertNotNull(ownerById);
        assertEquals(OWNER_ID, longCaptor.getValue());
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepositoryMock.findById(anyLong())).thenReturn(Optional.empty());
        Owner ownerById = ownerJpaService.findById(OWNER_ID);

        verify(ownerRepositoryMock).findById(longCaptor.capture());
        assertNull(ownerById);
    }

    @Test
    void save() {
        when(ownerRepositoryMock.save(any(Owner.class))).thenReturn(owner);
        Owner savedOwner = ownerJpaService.save(owner);

        verify(ownerRepositoryMock).save(ownerCaptor.capture());
        assertNotNull(savedOwner);
        assertEquals(owner, ownerCaptor.getValue());
    }

    @Test
    void delete() {
        ownerJpaService.delete(owner);

        verify(ownerRepositoryMock).delete(ownerCaptor.capture());
        assertEquals(owner, ownerCaptor.getValue());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(OWNER_ID);

        verify(ownerRepositoryMock).deleteById(longCaptor.capture());
        assertEquals(OWNER_ID, longCaptor.getValue());
    }
}