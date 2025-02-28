/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censusentry;

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
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.censusentry.CensusEntryConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;
import scot.carricksoftware.grants.services.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.people.PersonService;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class CensusEntryFormControllerImpl implements CensusEntryFormController {

    private static final Logger logger = LogManager.getLogger(CensusEntryFormControllerImpl.class);
    private final CensusEntryService censusEntryService;
    private final CensusService censusService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final CensusEntryCommandConverterImpl censusEntryCommandConverterImpl;
    private final CensusEntryConverterImpl censusEntryConverterImpl;
    private final PersonService personService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Capitalisation capitalisation;

    public CensusEntryFormControllerImpl(CensusEntryService censusEntryService,
                                         CensusService censusService,
                                         CensusEntryCommandConverterImpl censusEntryCommandConverterImpl,
                                         CensusEntryConverterImpl censusEntryConverterImpl,
                                         PersonService personService,
                                         Capitalisation capitalisation) {
        this.censusEntryService = censusEntryService;
        this.censusService = censusService;
        this.censusEntryCommandConverterImpl = censusEntryCommandConverterImpl;
        this.censusEntryConverterImpl = censusEntryConverterImpl;
        this.personService = personService;
        this.capitalisation = capitalisation;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUSENTRY_NEW)
    public final String getNewCensusEntry(final Model model) {
        logger.debug("CensusEntryFormControllerImpl::getNewCensusEntry");
        model.addAttribute(AttributeConstants.CENSUSENTRY_COMMAND, new CensusEntryCommand());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        model.addAttribute(AttributeConstants.CENSUSES, censusService.findAll());
        return ViewConstants.CENSUSENTRY_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUSENTRY_EDIT)
    public final String censusEntryEdit(@PathVariable final String id, Model model) {
        logger.debug("CensusEntryFormControllerImpl::censusEntryEdit");
        model.addAttribute(AttributeConstants.CENSUSENTRY_COMMAND, censusEntryConverterImpl.convert(censusEntryService.findById(Long.valueOf(id))));
        model.addAttribute(AttributeConstants.PLACES, personService.findAll());
        model.addAttribute(AttributeConstants.CENSUSES, censusService.findAll());
        return ViewConstants.CENSUSENTRY_FORM;
    }


    @Override
    @PostMapping(MappingConstants.CENSUSENTRY)
    public String saveOrUpdate(@Valid @ModelAttribute CensusEntryCommand censusEntryCommand, BindingResult bindingResult) {
        logger.debug("CensusEntryFormControllerImpl::saveOrUpdate");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.CENSUSENTRY_FORM;
        }

        CensusEntryCommand savedCommand = censusEntryService.saveCensusEntryCommand(censusEntryCommand);
        return MappingConstants.REDIRECT + MappingConstants.CENSUSENTRY_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUSENTRY_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("CensusEntryFormControllerImpl::saveOrUpdate");
        CensusEntryCommand savedCommand = censusEntryConverterImpl.convert(censusEntryService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.CENSUSENTRY_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.CENSUSENTRY_FORM;
    }


}
