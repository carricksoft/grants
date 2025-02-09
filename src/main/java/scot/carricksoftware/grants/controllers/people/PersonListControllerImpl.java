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
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

@Controller
public class PersonListControllerImpl {

    private static final Logger logger = LogManager.getLogger(PersonListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;

    private final PersonServiceImpl personService;

    public PersonListControllerImpl(ControllerHelper controllerHelper,
                                    PersonServiceImpl personService) {
        this.controllerHelper = controllerHelper;
        this.personService = personService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_LIST)
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getListPage");
        model.addAttribute("people", personService.getPagedPersons(0));
        controllerHelper.addAttributes(model);
        return ViewConstants.PEOPLE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_NEXT)
    public final String getNextPage(final Model model) {
        logger.debug("PersonListControllerImpl::getNextPage");
        currentPage++;
        model.addAttribute("people", personService.getPagedPersons(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.PEOPLE_LIST;
    }


}
