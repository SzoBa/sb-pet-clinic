package com.springpractice.sbpetclinic.controllers;

import com.springpractice.sbpetclinic.model.Owner;
import com.springpractice.sbpetclinic.model.Person;
import com.springpractice.sbpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll().stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList()));

        return "owners/index";
    }
}
