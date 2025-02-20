/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places;

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
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.countries.CountryCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.countries.CountryConverterImpl;
import scot.carricksoftware.grants.services.places.CountryService;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class CountryFormControllerImpl implements CountryFormController {

    private static final Logger logger = LogManager.getLogger(CountryFormControllerImpl.class);
    private final CountryService countryService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final CountryCommandConverterImpl countryCommandConverterImpl;
    private final CountryConverterImpl countryConverterImpl;
    private final Capitalisation capitalisation;


    public CountryFormControllerImpl(CountryService countryService,
                                     CountryCommandConverterImpl countryCommandConverterImpl,
                                     CountryConverterImpl countryConverterImpl,
                                     Capitalisation capitalisation) {
        this.countryService = countryService;
        this.countryCommandConverterImpl = countryCommandConverterImpl;
        this.countryConverterImpl = countryConverterImpl;
        this.capitalisation = capitalisation;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_NEW)
    public final String getNewCountry(final Model model) {
        logger.debug("CountryFormControllerImpl::getNewCountry");
        model.addAttribute(AttributeConstants.COUNTRY_COMMAND, new CountryCommand());
        return ViewConstants.COUNTRY_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_EDIT)
    public final String countryEdit(@PathVariable final String id, Model model) {
        logger.debug("CountryFormControllerImpl::countryEdit");
        model.addAttribute(AttributeConstants.COUNTRY_COMMAND, countryService.findById(Long.valueOf(id)));
        return ViewConstants.COUNTRY_FORM;
    }


    @Override
    @PostMapping(MappingConstants.COUNTRY)
    public String saveOrUpdate(@Valid @ModelAttribute CountryCommand countryCommand, BindingResult bindingResult) {
        logger.debug("CountryFormControllerImpl::saveOrUpdate");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.COUNTRY_FORM;
        }

        cleanUp(countryCommand);
        CountryCommand savedCommand = countryService.saveCountryCommand(countryCommand);
        return MappingConstants.REDIRECT + MappingConstants.COUNTRY_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(CountryCommand countryCommand) {
        countryCommand.setName(capitalisation.getCapitalisation(countryCommand.getName()));
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.COUNTRY_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("CountryFormControllerImpl::saveOrUpdate");
        CountryCommand savedCommand = countryConverterImpl.convert(countryService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.COUNTRY_COMMAND, savedCommand);
        return ViewConstants.COUNTRY_FORM;
    }


}
