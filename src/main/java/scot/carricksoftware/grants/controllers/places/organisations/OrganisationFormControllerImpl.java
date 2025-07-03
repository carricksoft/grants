/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers.places.organisations;

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
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverter;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverter;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.validators.places.OrganisationCommandValidator;

@Controller
public class OrganisationFormControllerImpl implements OrganisationFormController {

    private static final Logger logger = LogManager.getLogger(OrganisationFormControllerImpl.class);

    private final OrganisationService organisationService;
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final OrganisationCommandConverter organisationCommandConverter;
    private final OrganisationConverter organisationConverter;
    private final CapitaliseString capitaliseString;
    private final OrganisationCommandValidator organisationCommandValidator;

    public OrganisationFormControllerImpl(OrganisationService organisationService,
                                          OrganisationCommandConverter organisationCommandConverter,
                                          OrganisationConverter organisationConverter,
                                          CapitaliseString capitaliseString,
                                          OrganisationCommandValidator organisationCommandValidator) {
        this.organisationService = organisationService;
        this.organisationCommandConverter = organisationCommandConverter;
        this.organisationConverter = organisationConverter;
        this.capitaliseString = capitaliseString;
        this.organisationCommandValidator = organisationCommandValidator;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_NEW)
    @Override
    public final String getNewOrganisation(final Model model) {
        logger.debug("OrganisationFormControllerImpl::getNewOrganisation");
        model.addAttribute(AttributeConstants.ORGANISATION_COMMAND, new OrganisationCommandImpl());
        return ViewConstants.ORGANISATION_FORM;
    }

    @PostMapping(MappingConstants.ORGANISATION)
    @Override
    public String saveOrUpdate(@Valid @ModelAttribute OrganisationCommand organisationCommand, BindingResult bindingResult, Model model) {
        logger.debug("OrganisationFormControllerImpl::saveOrUpdate");

        organisationCommandValidator.validate(organisationCommand, bindingResult);

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.ORGANISATION_FORM;
        }

        cleanUp(organisationCommand);
        OrganisationCommand savedCommand = organisationService.saveOrganisationCommand(organisationCommand);
        model.addAttribute(AttributeConstants.ORGANISATION_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + MappingConstants.ORGANISATION_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    private void cleanUp(OrganisationCommand organisationCommand) {
        organisationCommand.setName(capitaliseString.capitalise(organisationCommand.getName()));
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_SHOW)
    @Override
    public String showById(@PathVariable String id, Model model) {
        logger.debug("OrganisationFormControllerImpl::showById");
        OrganisationCommand savedCommand = organisationConverter.convert(organisationService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.ORGANISATION_COMMAND, savedCommand);
        return ViewConstants.ORGANISATION_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.ORGANISATION_EDIT)
    @Override
    public final String organisationEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("OrganisationFormControllerImpl::organisationEdit");
        model.addAttribute(AttributeConstants.ORGANISATION_COMMAND, organisationService.findById(Long.valueOf(id)));
        return ViewConstants.ORGANISATION_FORM;
    }


}
