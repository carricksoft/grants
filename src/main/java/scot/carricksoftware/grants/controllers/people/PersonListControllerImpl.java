/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

@Controller
public class PersonListControllerImpl {

    private static final Logger logger = LogManager.getLogger(PersonListControllerImpl.class);
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private int currentPage = 0;

    private final PersonServiceImpl personService;

    public PersonListControllerImpl(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_LIST)
    public final String getListPage(final Model model, @RequestParam(defaultValue = "0") final int pageNumber) {
        logger.debug("PersonListControllerImpl::getListPage");
        currentPage = pageNumber;
        model.addAttribute("Persons", personService.getPagedPersons(pageNumber));
        return ViewConstants.PEOPLE_LIST;
    }


}
