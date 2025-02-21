/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.census;

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
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.census.CensusCommandConverterImpl;
import scot.carricksoftware.grants.converters.census.CensusConverterImpl;
import scot.carricksoftware.grants.services.census.CensusService;

@SuppressWarnings({"LoggingSimilarMessage", "unused"})
@Controller
public class CensusFormControllerImpl implements CensusFormController {
   
    private static final Logger logger = LogManager.getLogger(CensusFormControllerImpl.class);
    private final CensusService censusService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final CensusCommandConverterImpl censusCommandConverterImpl;
    private final CensusConverterImpl censusConverterImpl;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Capitalisation capitalisation;


    public CensusFormControllerImpl(CensusService censusService,
                                     CensusCommandConverterImpl censusCommandConverterImpl,
                                     CensusConverterImpl censusConverterImpl,
                                     Capitalisation capitalisation) {
        this.censusService = censusService;
        this.censusCommandConverterImpl = censusCommandConverterImpl;
        this.censusConverterImpl = censusConverterImpl;
        this.capitalisation = capitalisation;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_NEW)
    public final String getNewCensus(final Model model) {
        logger.debug("CensusFormControllerImpl::getNewCensus");
        model.addAttribute(AttributeConstants.CENSUS_COMMAND, new CensusCommand());
        return ViewConstants.CENSUS_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_EDIT)
    public final String censusEdit(@PathVariable final String id, Model model) {
        logger.debug("CensusFormControllerImpl::censusEdit");
        model.addAttribute(AttributeConstants.CENSUS_COMMAND, censusService.findById(Long.valueOf(id)));
        return ViewConstants.CENSUS_FORM;
    }


    @Override
    @PostMapping(MappingConstants.CENSUS)
    public String saveOrUpdate(@Valid @ModelAttribute CensusCommand censusCommand, BindingResult bindingResult) {
        logger.debug("CensusFormControllerImpl::saveOrUpdate");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.CENSUS_FORM;
        }

        CensusCommand savedCommand = censusService.saveCensusCommand(censusCommand);
        return MappingConstants.REDIRECT + MappingConstants.CENSUS_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.CENSUS_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("CensusFormControllerImpl::saveOrUpdate");
        CensusCommand savedCommand = censusConverterImpl.convert(censusService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.CENSUS_COMMAND, savedCommand);
        return ViewConstants.CENSUS_FORM;
    }

 
}
