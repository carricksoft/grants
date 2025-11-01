/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.census;

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
import scot.carricksoftware.grants.capitalisation.census.census.CapitaliseCensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.CensusMappingConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.census.CensusConverter;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.census.census.CensusCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class CensusFormControllerImpl implements CensusFormController {

    private static final Logger logger = LogManager.getLogger(CensusFormControllerImpl.class);
    private final CensusService censusService;
    private final CensusCommandValidator censusCommandValidator;
    private final CapitaliseCensusCommand capitaliseCensusCommand;
    private final CensusConverter censusConverter;
    private final PlaceService placeService;


    public CensusFormControllerImpl(CensusService censusService,
                                    CensusCommandValidator censusCommandValidator,
                                    CapitaliseCensusCommand capitaliseCensusCommandImpl,
                                    CensusConverter censusConverter,
                                    PlaceService placeService) {
        this.censusService = censusService;
        this.censusCommandValidator = censusCommandValidator;
        this.capitaliseCensusCommand = capitaliseCensusCommandImpl;
        this.censusConverter = censusConverter;
        this.placeService = placeService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.CENSUS_NEW)
    public final String getNewCensus(final Model model) {
        logger.debug("CensusFormControllerImpl::getNewCensus");
        model.addAttribute(AttributeConstants.CENSUS_COMMAND, new CensusCommandImpl());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.CENSUS_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.CENSUS_EDIT)
    public final String censusEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("CensusFormControllerImpl::censusEdit");
        model.addAttribute(AttributeConstants.CENSUS_COMMAND, censusService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.CENSUS_FORM;
    }


    @Override
    @PostMapping(CensusMappingConstants.CENSUS)
    public String saveOrUpdate(@Valid @ModelAttribute CensusCommand censusCommand, BindingResult bindingResult, Model model) {
        logger.debug("CensusFormControllerImpl::saveOrUpdate");

        capitaliseCensusCommand.capitalise(censusCommand);
        censusCommandValidator.validate(censusCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
            return ViewConstants.CENSUS_FORM;
        }


        CensusCommand savedCommand = censusService.saveCensusCommand(censusCommand);
        model.addAttribute(AttributeConstants.CENSUS_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return MappingConstants.REDIRECT + CensusMappingConstants.CENSUS_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(CensusMappingConstants.CENSUS_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("CensusFormControllerImpl::saveOrUpdate");
        CensusCommand savedCommand = censusConverter.convert(censusService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.CENSUS_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.CENSUS_FORM;
    }


}
