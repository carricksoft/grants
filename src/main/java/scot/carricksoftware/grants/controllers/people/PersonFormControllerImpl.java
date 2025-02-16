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
import scot.carricksoftware.grants.converters.Capitalisation;
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
    private final Capitalisation capitalisation;

    public PersonFormControllerImpl(PersonService personService,
                                    PersonCommandConverterImpl personCommandConverterImpl,
                                    PersonConverterImpl personConverterImpl,
                                    Capitalisation capitalisation) {
        this.personService = personService;
        this.personCommandConverterImpl = personCommandConverterImpl;
        this.personConverterImpl = personConverterImpl;
        this.capitalisation = capitalisation;
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_NEW)
    public final String getNewPerson(final Model model) {
        logger.debug("PersonFormControllerImpl::getNewPerson");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, new PersonCommand());
        return ViewConstants.PERSON_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_EDIT)
    public final String personEdit(@PathVariable final String id, Model model) {
        logger.debug("PersonFormControllerImpl::personEdit");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, personService.findById(Long.valueOf(id)));
        return ViewConstants.PERSON_FORM;
    }


    @Override
    @PostMapping(MappingConstants.PERSON)
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand, Model model) {
        logger.debug("PersonFormControllerImpl::saveOrUpdate");

        cleanUp(personCommand);
        PersonCommand savedCommand = personService.savePersonCommand(personCommand);
        return MappingConstants.REDIRECT + MappingConstants.PERSON_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(PersonCommand personCommand) {
        personCommand.setFirstName(capitalisation.getCapitalisation(personCommand.getFirstName()));
        personCommand.setLastName(capitalisation.getCapitalisation(personCommand.getLastName()));
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
