package com.springpractice.sbpetclinic.controllers;

import com.springpractice.sbpetclinic.model.BaseEntity;
import com.springpractice.sbpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class VetController {

    @Autowired
    private VetService vetService;


    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll().stream().sorted(Comparator.comparing(BaseEntity::getId)).collect(Collectors.toList()));

        return "vets/index";
    }

}
