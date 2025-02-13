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
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;

@Controller
public class PersonFormControllerImpl {

    private static final Logger logger = LogManager.getLogger(PersonFormControllerImpl.class);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PEOPLE_NEW)
    public final String getNewPerson(final Model model) {
        logger.debug("PersonFormControllerImpl::getNewPerson");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, new PersonCommand());
        return ViewConstants.PEOPLE_FORM;
    }

}
