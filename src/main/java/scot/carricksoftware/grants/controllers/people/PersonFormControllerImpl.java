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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.services.people.PersonService;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class PersonFormControllerImpl implements PersonFormController {

    private static final Logger logger = LogManager.getLogger(PersonFormControllerImpl.class);
    private final PersonService personService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PersonCommandConverterImpl personCommandConverterImpl;
    private final PersonConverterImpl personConverterImpl;

    public PersonFormControllerImpl(PersonService personService, PersonCommandConverterImpl personCommandConverterImpl, PersonConverterImpl personConverterImpl) {
        this.personService = personService;
        this.personCommandConverterImpl = personCommandConverterImpl;
        this.personConverterImpl = personConverterImpl;
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_NEW)
    public final String getNewPerson(final Model model) {
        logger.debug("PersonFormControllerImpl::getNewPerson");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, new PersonCommand());
        return ViewConstants.PERSON_FORM;
    }


    @SuppressWarnings("SpringMVCViewInspection")
    @Override
    @PostMapping(MappingConstants.PERSON)
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand) {
        logger.debug("PersonFormControllerImpl::saveOrUpdate");
        PersonCommand savedCommand = personService.savePersonCommand(personCommand);
        return ViewConstants.REDIRECT + ViewConstants.PERSON_SHOW + "/" + savedCommand.getId();
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PersonFormControllerImpl::saveOrUpdate");
        PersonCommand savedCommand = personConverterImpl.convert(personService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PERSON_COMMAND, savedCommand);
        return ViewConstants.PERSON_FORM;
    }


}
