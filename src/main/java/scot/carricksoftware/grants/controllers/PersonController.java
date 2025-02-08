/*
 * Copyright (c)  07 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.services.people.PersonService;

@Controller
public class PersonController {
    /**
     * Created by jt on 6/1/17.
     */

    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_LIST)
    public String getListPage(Model model) {
        model.addAttribute("people", personService.findAll());
        return ViewConstants.PEOPLE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_NEXT)
    public String getNextPage(Model model) {
        model.addAttribute("people", personService.findAll('+'));
        return ViewConstants.PEOPLE_LIST;

    }


}
