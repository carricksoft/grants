/*
 * Copyright (c) Andrew Grant of Carrick Software 25/03/2025, 19:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.certificates.marriagecertificates;

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
import scot.carricksoftware.grants.capitalisation.certificates.marriagecertificates.CapitaliseMarriageCertificate;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.CertificateMappingConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateCommandConverterImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.MarriageCertificateConverterImpl;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;
import scot.carricksoftware.grants.services.places.places.PlaceService;
import scot.carricksoftware.grants.validators.certificates.marriagecertificate.MarriageCertificateCommandValidator;

@SuppressWarnings("LoggingSimilarMessage")
@Controller
public class MarriageCertificateFormControllerImpl implements MarriageCertificateFormController {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateFormControllerImpl.class);
    private final MarriageCertificateService marriageCertificateService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final MarriageCertificateCommandConverterImpl marriageCertificateCommandConverter;
    private final MarriageCertificateConverterImpl marriageCertificateConverter;
    private final MarriageCertificateCommandValidator marriageCertificateCommandValidator;
    private final PersonService personService;
    private final OrganisationService organisationService;
    private final PlaceService placeService;
    private final CapitaliseMarriageCertificate capitaliseMarriageCertificate;


    public MarriageCertificateFormControllerImpl(MarriageCertificateService marriageCertificateService,
                                                 MarriageCertificateCommandConverterImpl marriageCertificateCommandConverter,
                                                 MarriageCertificateConverterImpl marriageCertificateConverter,
                                                 MarriageCertificateCommandValidator marriageCertificateCommandValidator,
                                                 PersonService personService, OrganisationService organisationService, PlaceService placeService, CapitaliseMarriageCertificate capitaliseMarriageCertificate) {
        this.marriageCertificateService = marriageCertificateService;
        this.marriageCertificateCommandConverter = marriageCertificateCommandConverter;


        this.marriageCertificateConverter = marriageCertificateConverter;
        this.marriageCertificateCommandValidator = marriageCertificateCommandValidator;
        this.personService = personService;
        this.organisationService = organisationService;
        this.placeService = placeService;
        this.capitaliseMarriageCertificate = capitaliseMarriageCertificate;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_NEW)
    @Override
    public final String getNewMarriageCertificate(final Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::getNewMarriageCertificate");
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, new MarriageCertificateCommandImpl());
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.findAll());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_EDIT)
    @Override
    public final String marriageCertificateEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::marriageCertificateEdit");
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, marriageCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.findAll());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
    }


    @Override
    @PostMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE)
    public String saveOrUpdate(@Valid @ModelAttribute MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult, Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::saveOrUpdate");

        marriageCertificateCommandValidator.validate(marriageCertificateCommand, bindingResult);
        capitaliseMarriageCertificate.capitalise(marriageCertificateCommand);



        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
            model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.findAll());
            model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
            return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
        }

        MarriageCertificateCommand savedCommand = marriageCertificateService.saveMarriageCertificateCommand(marriageCertificateCommand);
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.findAll());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return MappingConstants.REDIRECT + CertificateMappingConstants.MARRIAGE_CERTIFICATE_SHOW.replace("{id}", "" + savedCommand.getId());
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(CertificateMappingConstants.MARRIAGE_CERTIFICATE_SHOW)
    @Override
    public String showById(@PathVariable String id, Model model) {
        logger.debug("MarriageCertificateFormControllerImpl::saveOrUpdate");
        MarriageCertificateCommand savedCommand = marriageCertificateConverter.convert(marriageCertificateService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.MARRIAGE_CERTIFICATE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.PEOPLE, personService.findAll());
        model.addAttribute(AttributeConstants.ORGANISATIONS, organisationService.findAll());
        model.addAttribute(AttributeConstants.PLACES, placeService.findAll());
        return ViewConstants.MARRIAGE_CERTIFICATE_FORM;
    }


}
