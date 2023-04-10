package com.springpractice.sbpetclinic.controllers;

import com.springpractice.sbpetclinic.model.Owner;
import com.springpractice.sbpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @InjectMocks
    OwnerController ownerController;
    @Mock
    OwnerService ownerServiceMock;

    MockMvc mockMvc;
    Set<Owner> owners;
    final Long ownerId1 = 1L;
    final Long ownerId2 = 2L;

    @BeforeEach
    void setUp() {
        owners = Set.of(
                Owner.builder().id(ownerId1).build(),
                Owner.builder().id(ownerId2).build());

        mockMvc = MockMvcBuilders.
                standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerServiceMock.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerServiceMock.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));

        verifyNoInteractions(ownerServiceMock);
    }
}