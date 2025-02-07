/*
 * Copyright (c)  06 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import scot.carricksoftware.grants.constants.Button;
import scot.carricksoftware.grants.services.people.PersonService;

@Controller
public class PersonController {
    /**
     * Created by jt on 6/1/17.
     */

    final PersonService personService;
    final Button button;

    public PersonController(PersonService personService, Button button) {
        this.personService = personService;
        this.button = button;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/people")
    public String getListPage(Model model) {
        model.addAttribute("people", personService.findAll());
        model.addAttribute("button", button);
        model.addAttribute("button", button);

        return "person/list";
    }
}
