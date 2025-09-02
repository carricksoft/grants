/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.divorcecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;



@Component
public class DivorceCertificateCommandValidatorImpl implements DivorceCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(DivorceCertificateCommandValidatorImpl.class);

    final DivorceCertificateCommandPeopleValidator divorceCertificateCommandPeopleValidator;

    final DivorceCertificateCommandDatesValidator divorceCertificateCommandDatesValidator;

    public DivorceCertificateCommandValidatorImpl(DivorceCertificateCommandPeopleValidator divorceCertificateCommandPeopleValidator,
                                                  DivorceCertificateCommandDatesValidator divorceCertificateCommandDatesValidator) {
        this.divorceCertificateCommandPeopleValidator = divorceCertificateCommandPeopleValidator;
        this.divorceCertificateCommandDatesValidator = divorceCertificateCommandDatesValidator;
    }


    @Override
    public void validate(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificateCommandValidator::validate");
        divorceCertificateCommandPeopleValidator.validate(divorceCertificateCommand, bindingResult);
        divorceCertificateCommandDatesValidator.validate(divorceCertificateCommand, bindingResult);
    }


}

