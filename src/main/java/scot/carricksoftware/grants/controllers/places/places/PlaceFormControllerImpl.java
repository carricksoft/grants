/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

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
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class PlaceFormControllerImpl implements PlaceFormController {

    private static final Logger logger = LogManager.getLogger(PlaceFormControllerImpl.class);
    private final PlaceService placeService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PlaceCommandConverterImpl placeCommandConverterImpl;
    private final PlaceConverterImpl placeConverterImpl;
    private final Capitalisation capitalisation;
    private final CountryService countryService;


    public PlaceFormControllerImpl(PlaceService placeService,
                                   PlaceCommandConverterImpl placeCommandConverterImpl,
                                   PlaceConverterImpl placeConverterImpl,
                                   Capitalisation capitalisation,
                                   CountryService countryService) {
        this.placeService = placeService;
        this.placeCommandConverterImpl = placeCommandConverterImpl;
        this.placeConverterImpl = placeConverterImpl;
        this.capitalisation = capitalisation;
        this.countryService = countryService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_NEW)
    public final String getNewPlace(final Model model) {
        logger.debug("PlaceFormControllerImpl::getNewPlace");
        model.addAttribute(AttributeConstants.PLACE_COMMAND, new PlaceCommand());
        model.addAttribute(AttributeConstants.COUNTRIES, countryService.findAll());
        return ViewConstants.PLACE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_EDIT)
    public final String placeEdit(@PathVariable final String id, Model model) {
        logger.debug("PlaceFormControllerImpl::placeEdit");
        model.addAttribute(AttributeConstants.PLACE_COMMAND, placeService.findById(Long.valueOf(id)));
        return ViewConstants.PLACE_FORM;
    }


    @Override
    @PostMapping(MappingConstants.PLACE)
    public String saveOrUpdate(@Valid @ModelAttribute PlaceCommand placeCommand, BindingResult bindingResult) {
        logger.debug("PlaceFormControllerImpl::saveOrUpdate");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.PLACE_FORM;
        }

        cleanUp(placeCommand);
        PlaceCommand savedCommand = placeService.savePlaceCommand(placeCommand);
        return MappingConstants.REDIRECT + MappingConstants.PLACE_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(PlaceCommand placeCommand) {
        placeCommand.setName(capitalisation.getCapitalisation(placeCommand.getName()));
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.PLACE_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("PlaceFormControllerImpl::saveOrUpdate");
        PlaceCommand savedCommand = placeConverterImpl.convert(placeService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PLACE_COMMAND, savedCommand);
        return ViewConstants.PLACE_FORM;
    }


}
