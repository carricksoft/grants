/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

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
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.Capitalisation;
import scot.carricksoftware.grants.converters.places.regions.RegionCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.regions.RegionConverterImpl;
import scot.carricksoftware.grants.services.places.RegionService;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class RegionFormControllerImpl implements RegionFormController {

    private static final Logger logger = LogManager.getLogger(RegionFormControllerImpl.class);
    private final RegionService regionService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final RegionCommandConverterImpl regionCommandConverterImpl;
    private final RegionConverterImpl regionConverterImpl;
    private final Capitalisation capitalisation;


    public RegionFormControllerImpl(RegionService regionService,
                                    RegionCommandConverterImpl regionCommandConverterImpl,
                                    RegionConverterImpl regionConverterImpl,
                                    Capitalisation capitalisation) {
        this.regionService = regionService;
        this.regionCommandConverterImpl = regionCommandConverterImpl;
        this.regionConverterImpl = regionConverterImpl;
        this.capitalisation = capitalisation;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_NEW)
    public final String getNewRegion(final Model model) {
        logger.debug("RegionFormControllerImpl::getNewRegion");
        model.addAttribute(AttributeConstants.REGION_COMMAND, new RegionCommand());
        return ViewConstants.REGION_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_EDIT)
    public final String regionEdit(@PathVariable final String id, Model model) {
        logger.debug("RegionFormControllerImpl::regionEdit");
        model.addAttribute(AttributeConstants.REGION_COMMAND, regionService.findById(Long.valueOf(id)));
        return ViewConstants.REGION_FORM;
    }


    @Override
    @PostMapping(MappingConstants.REGION)
    public String saveOrUpdate(@Valid @ModelAttribute
                               RegionCommand regionCommand, BindingResult bindingResult) {
        logger.debug("RegionFormControllerImpl::saveOrUpdate");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.REGION_FORM;
        }

        cleanUp(regionCommand);
        RegionCommand savedCommand = regionService.saveRegionCommand(regionCommand);
        return MappingConstants.REDIRECT + MappingConstants.REGION_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(RegionCommand regionCommand) {
        regionCommand.setName(capitalisation.getCapitalisation(regionCommand.getName()));
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.REGION_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("RegionFormControllerImpl::saveOrUpdate");
        RegionCommand savedCommand = regionConverterImpl.convert(regionService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.REGION_COMMAND, savedCommand);
        return ViewConstants.REGION_FORM;
    }


}
