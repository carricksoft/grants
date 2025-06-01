/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@Component
public class BirthCertificateCommandPartTwoValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartTwoValidator.class);

    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part two)");

        validateNumber(birthCertificateCommand, bindingResult);
        validateVolume(birthCertificateCommand, bindingResult);
        validateRegistrationAuthority(birthCertificateCommand, bindingResult);
    }


    private void validateNumber(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating registration number");
        if (birthCertificateCommand.getNumber() == null || birthCertificateCommand.getNumber().isEmpty()) {
            bindingResult.rejectValue("number", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.NUMBER_IS_NULL);
        } else {
            try {
                int number = Integer.parseInt(birthCertificateCommand.getNumber());
                if (number < 0) {
                    bindingResult.rejectValue("number", ApplicationConstants.EMPTY_STRING,
                            null,
                            ValidationConstants.NUMBER_IS_INVALID);
                }
            } catch (NumberFormatException e) {
                bindingResult.rejectValue("number", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.NUMBER_IS_INVALID);
            }
        }
    }


    private void validateVolume(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating number Registration Volume");
        if (birthCertificateCommand.getVolume() == null || birthCertificateCommand.getVolume().isEmpty()) {
            bindingResult.rejectValue("volume", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.REGISTRATION_VOLUME_IS_NULL);
        }
    }

    private void validateRegistrationAuthority(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Registration Authority");
        if (birthCertificateCommand.getRegistrationAuthority() == null) {
            bindingResult.rejectValue("registrationAuthority", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.REGISTRATION_AUTHORITY_IS_NULL);
        }
    }

}

