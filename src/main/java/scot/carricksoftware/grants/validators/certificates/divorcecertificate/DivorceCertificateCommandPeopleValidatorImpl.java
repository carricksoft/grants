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
public class DivorceCertificateCommandPeopleValidatorImpl implements DivorceCertificateCommandPeopleValidator {

    private static final Logger logger = LogManager.getLogger(DivorceCertificateCommandPeopleValidatorImpl.class);

    @Override
    public void validate(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.info("DivorceCertificateCommandPeopleValidator::validate");

    }
}

