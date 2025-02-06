/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/people")
    public String getListPage(Model model) {
        model.addAttribute("people", personService.findAll());
        return "person/list";
    }
}
