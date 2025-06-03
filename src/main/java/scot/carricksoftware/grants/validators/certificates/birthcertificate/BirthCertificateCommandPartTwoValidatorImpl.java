/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.birthcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

@Component
public class BirthCertificateCommandPartTwoValidatorImpl implements BirthCertificateCommandPartTwoValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartTwoValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public BirthCertificateCommandPartTwoValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part two)");

        validateNumber(birthCertificateCommand, bindingResult);
        validateVolume(birthCertificateCommand, bindingResult);
        validateRegistrationAuthority(birthCertificateCommand, bindingResult);
    }


    private void validateNumber(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating registration number");
        validateTypes.validateNonNegativeInteger(birthCertificateCommand.getNumber(), "volume", ValidationConstants.NUMBER_IS_NULL, ValidationConstants.NUMBER_IS_INVALID,bindingResult);
    }

    private void validateVolume(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating number Registration Volume");
        validateTypes.validateNullOrEmptyString(birthCertificateCommand.getVolume(), "volume", ValidationConstants.REGISTRATION_VOLUME_IS_NULL,bindingResult);
    }

    private void validateRegistrationAuthority(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Registration Authority");
        validateTypes.validateOrganisation(birthCertificateCommand.getRegistrationAuthority(), "certificateSource", ValidationConstants.REGISTRATION_AUTHORITY_IS_NULL, bindingResult);
    }

}

