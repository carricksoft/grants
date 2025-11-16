/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grants.cache.BMDCache;
import scot.carricksoftware.grants.capitalisation.people.CapitalisePerson;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.people.PersonCommandConverter;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.people.PersonCommandValidator;

@Controller
public class PersonFormControllerImpl implements PersonFormController {

    private static final Logger logger = LogManager.getLogger(PersonFormControllerImpl.class);

    private final PersonService personService;
    private final PersonConverter personConverter;
    private final CapitalisePerson capitalisePerson;
    private final PersonCommandValidator personCommandValidator;
    private final BMDCache bmdCache;
    private final ImageService imageService;


    public PersonFormControllerImpl(PersonService personService,
                                    PersonCommandConverter personCommandConverter,
                                    PersonConverter personConverter,
                                    CapitalisePerson capitalisePerson,
                                    PersonCommandValidator personCommandValidator,
                                    BMDCache bmdCache,
                                    ImageService imageService) {
        this.personService = personService;

        this.personConverter = personConverter;
        this.capitalisePerson = capitalisePerson;
        this.personCommandValidator = personCommandValidator;
        this.bmdCache = bmdCache;
        this.imageService = imageService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_NEW)
    public final String getNewPerson(final Model model) {
        logger.debug("PersonFormControllerImpl::getNewPerson");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, new PersonCommandImpl());
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.PERSON_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_EDIT)
    public final String personEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("PersonFormControllerImpl::personEdit");
        model.addAttribute(AttributeConstants.PERSON_COMMAND, personService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.PERSON_FORM;
    }


    @Override
    @PostMapping(MappingConstants.PERSON)
    public String saveOrUpdate(@Valid @ModelAttribute PersonCommand personCommand, BindingResult bindingResult, Model model) {
        logger.debug("PersonFormControllerImpl::saveOrUpdate");

        capitalisePerson.capitalise(personCommand);
        personCommandValidator.validate(personCommand, bindingResult);
        bmdCache.invalidatePeople();

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.PERSON_FORM;
        }


        PersonCommand savedCommand = personService.savePersonCommand(personCommand);
        model.addAttribute(AttributeConstants.PERSON_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return MappingConstants.REDIRECT + MappingConstants.PERSON_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PERSON_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PersonFormControllerImpl::showById");
        PersonCommand savedCommand = personConverter.convert(personService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PERSON_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.PERSON_FORM;
    }


}
