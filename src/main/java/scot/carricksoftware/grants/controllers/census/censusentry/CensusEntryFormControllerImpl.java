/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;

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
import scot.carricksoftware.grants.capitalisation.census.censusentry.CapitaliseCensusEntry;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.CensusMappingConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.census.CensusEntryConverter;
import scot.carricksoftware.grants.services.census.censusentry.CensusEntryService;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.censusentry.UpdateRecordedYearOfBirth;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.validators.census.censusentry.CensusEntryCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class CensusEntryFormControllerImpl implements CensusEntryFormController {

    private static final Logger logger = LogManager.getLogger(CensusEntryFormControllerImpl.class);
    private final CensusEntryService censusEntryService;
    private final CensusEntryCommandValidator censusEntryCommandValidator;
    private final CensusEntryConverter censusEntryConverter;
    private final CapitaliseCensusEntry capitaliseCensusEntry;
    private final PersonService personService;
    private final CensusService censusService;
    private final UpdateRecordedYearOfBirth updateRecordedYearOfBirth;



    public CensusEntryFormControllerImpl(CensusEntryService censusEntryService,
                                         CensusEntryCommandValidator censusEntryCommandValidator,
                                         CensusEntryConverter censusEntryConverter,
                                         CapitaliseCensusEntry capitaliseCensusEntry,
                                         PersonService personService,
                                         CensusService censusService, UpdateRecordedYearOfBirth updateRecordedYearOfBirth) {
        this.censusEntryService = censusEntryService;
        this.censusEntryCommandValidator = censusEntryCommandValidator;
        this.censusEntryConverter = censusEntryConverter;
        this.capitaliseCensusEntry = capitaliseCensusEntry;
        this.personService = personService;
        this.censusService = censusService;
        this.updateRecordedYearOfBirth = updateRecordedYearOfBirth;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.CENSUS_ENTRY_NEW)
    public final String getNewCensusEntry(final Model model) {
        logger.debug("CensusEntryFormControllerImpl::getNewCensusEntry");
        model.addAttribute(AttributeConstants.CENSUS_ENTRY_COMMAND, new CensusEntryCommandImpl());
        model.addAttribute(AttributeConstants.CENSUSES, censusService.findAll());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.CENSUS_ENTRY_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.CENSUS_ENTRY_EDIT)
    public final String censusEntryEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("CensusEntryFormControllerImpl::censusEntryEdit");
        model.addAttribute(AttributeConstants.CENSUS_ENTRY_COMMAND, censusEntryService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.CENSUSES, censusService.findAll());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        return ViewConstants.CENSUS_ENTRY_FORM;
    }


    @Override
    @PostMapping(CensusMappingConstants.CENSUS_ENTRY)
    public String saveOrUpdate(@Valid @ModelAttribute CensusEntryCommand censusEntryCommand, BindingResult bindingResult, Model model) {
        logger.debug("CensusEntryFormControllerImpl::saveOrUpdate");

        capitaliseCensusEntry.capitalise(censusEntryCommand);
        censusEntryCommandValidator.validate(censusEntryCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            model.addAttribute(AttributeConstants.CENSUSES, censusService.findAll());
            return ViewConstants.CENSUS_ENTRY_FORM;
        }

        CensusEntryCommand savedCommand = censusEntryService.saveCensusEntryCommand(censusEntryCommand);
        updateRecordedYearOfBirth.updateRecordedYearOfBirth(savedCommand);
        model.addAttribute(AttributeConstants.CENSUS_ENTRY_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + CensusMappingConstants.CENSUS_ENTRY_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.CENSUS_ENTRY_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("CensusEntryFormControllerImpl::saveOrUpdate");
        CensusEntryCommand savedCommand = censusEntryConverter.convert(censusEntryService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        model.addAttribute(AttributeConstants.CENSUS_ENTRY_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.CENSUSES, censusService.findAll());
        return ViewConstants.CENSUS_ENTRY_FORM;
    }


}
