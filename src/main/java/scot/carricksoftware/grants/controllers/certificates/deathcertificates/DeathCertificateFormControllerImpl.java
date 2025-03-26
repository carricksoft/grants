/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.deathcertificates;

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
import scot.carricksoftware.grants.commands.certificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.deathcertificates.DeathCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.validators.certificates.DeathCertificateCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class DeathCertificateFormControllerImpl implements DeathCertificateFormController {

    private static final Logger logger = LogManager.getLogger(DeathCertificateFormControllerImpl.class);
    private final DeathCertificateService deathCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final DeathCertificateCommandConverterImpl deathCertificateCommandConverter;
    private final DeathCertificateConverterImpl deathCertificateConverter;
    private final DeathCertificateCommandValidator deathCertificateCommandValidator;


    public DeathCertificateFormControllerImpl(DeathCertificateService deathCertificateService,
                                              DeathCertificateCommandConverterImpl deathCertificateCommandConverter,
                                              DeathCertificateConverterImpl deathCertificateConverter,
                                              DeathCertificateCommandValidator deathCertificateCommandValidator) {
        this.deathCertificateService = deathCertificateService;
        this.deathCertificateCommandConverter = deathCertificateCommandConverter;


        this.deathCertificateConverter = deathCertificateConverter;
        this.deathCertificateCommandValidator = deathCertificateCommandValidator;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATHCERTIFICATE_NEW)
    @Override
    public final String getNewDeathCertificate(final Model model) {
        logger.debug("DeathCertificateFormControllerImpl::getNewDeathCertificate");
        model.addAttribute(AttributeConstants.DEATHCERTIFICATE_COMMAND, new DeathCertificateCommandImpl());
        return ViewConstants.DEATHCERTIFICATE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATHCERTIFICATE_EDIT)
    @Override
    public final String deathCertificateEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("DeathCertificateFormControllerImpl::deathCertificateEdit");
        model.addAttribute(AttributeConstants.DEATHCERTIFICATE_COMMAND, deathCertificateService.findById(Long.valueOf(id)));
        return ViewConstants.DEATHCERTIFICATE_FORM;
    }


    @Override
    @PostMapping(MappingConstants.DEATHCERTIFICATE)
    public String saveOrUpdate(@Valid @ModelAttribute DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult, Model model) {
        logger.debug("DeathCertificateFormControllerImpl::saveOrUpdate");

        deathCertificateCommandValidator.validate(deathCertificateCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.DEATHCERTIFICATE_FORM;
        }

        DeathCertificateCommand savedCommand = deathCertificateService.saveDeathCertificateCommand(deathCertificateCommand);
        model.addAttribute(AttributeConstants.DEATHCERTIFICATE_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + MappingConstants.DEATHCERTIFICATE_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.DEATHCERTIFICATE_SHOW)
    @Override
    public String showById(@PathVariable String id, Model model) {
        logger.debug("DeathCertificateFormControllerImpl::saveOrUpdate");
        DeathCertificateCommand savedCommand = deathCertificateConverter.convert(deathCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.DEATHCERTIFICATE_COMMAND, savedCommand);
        return ViewConstants.DEATHCERTIFICATE_FORM;
    }


}
