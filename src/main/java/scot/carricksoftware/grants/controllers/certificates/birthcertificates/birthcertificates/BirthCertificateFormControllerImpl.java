/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates.birthcertificates;

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
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.birthcertificates.BirthCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.BirthCertificateService;
import scot.carricksoftware.grants.validators.certificates.BirthCertificateCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class BirthCertificateFormControllerImpl implements BirthCertificateFormController {

    private static final Logger logger = LogManager.getLogger(BirthCertificateFormControllerImpl.class);
    private final BirthCertificateService birthCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final BirthCertificateCommandConverterImpl birthCertificateCommandConverter;
    private final BirthCertificateConverterImpl birthCertificateConverter;
    private final BirthCertificateCommandValidator birthCertificateCommandValidator;


    public BirthCertificateFormControllerImpl(BirthCertificateService birthCertificateService,
                                              BirthCertificateCommandConverterImpl birthCertificateCommandConverter,
                                              BirthCertificateConverterImpl birthCertificateConverter,
                                              BirthCertificateCommandValidator birthCertificateCommandValidator) {
        this.birthCertificateService = birthCertificateService;
        this.birthCertificateCommandConverter = birthCertificateCommandConverter;


        this.birthCertificateConverter = birthCertificateConverter;
        this.birthCertificateCommandValidator = birthCertificateCommandValidator;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_NEW)
    public final String getNewBirthCertificate(final Model model) {
        logger.debug("BirthCertificateFormControllerImpl::getNewBirthCertificate");
        model.addAttribute(AttributeConstants.BIRTHCERTIFICATE_COMMAND, new BirthCertificateCommandImpl());
        return ViewConstants.BIRTHCERTIFICATE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_EDIT)
    public final String birthCertificateEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("BirthCertificateFormControllerImpl::birthCertificateEdit");
        model.addAttribute(AttributeConstants.BIRTHCERTIFICATE_COMMAND, birthCertificateService.findById(Long.valueOf(id)));
        return ViewConstants.BIRTHCERTIFICATE_FORM;
    }


    @Override
    @PostMapping(MappingConstants.BIRTHCERTIFICATE)
    public String saveOrUpdate(@Valid @ModelAttribute BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult, Model model) {
        logger.debug("BirthCertificateFormControllerImpl::saveOrUpdate");

        birthCertificateCommandValidator.validate(birthCertificateCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.BIRTHCERTIFICATE_FORM;
        }

        BirthCertificateCommand savedCommand = birthCertificateService.saveBirthCertificateCommand(birthCertificateCommand);
        model.addAttribute(AttributeConstants.BIRTHCERTIFICATE_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + MappingConstants.BIRTHCERTIFICATE_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("BirthCertificateFormControllerImpl::saveOrUpdate");
        BirthCertificateCommand savedCommand = birthCertificateConverter.convert(birthCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.BIRTHCERTIFICATE_COMMAND, savedCommand);
        return ViewConstants.BIRTHCERTIFICATE_FORM;
    }


}
