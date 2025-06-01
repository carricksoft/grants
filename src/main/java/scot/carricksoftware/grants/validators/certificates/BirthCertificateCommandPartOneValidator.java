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

import java.time.LocalDate;

@Component
public class BirthCertificateCommandPartOneValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartOneValidator.class);

    @SuppressWarnings("unused")
    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part one)");

        validateNewBorn(birthCertificateCommand, bindingResult);
        validateCertificateNumber(birthCertificateCommand, bindingResult);
        validateCertificateSource(birthCertificateCommand, bindingResult);
        validateCertificateType(birthCertificateCommand, bindingResult);
        validateCertificateDate(birthCertificateCommand, bindingResult);
        if (!bindingResult.hasErrors()) {
            validateCertificateLegitimateDate(birthCertificateCommand, bindingResult);
        }
    }

    private void validateNewBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate newBorn");
        if (birthCertificateCommand.getNewBorn() == null ) {
            bindingResult.rejectValue("newBorn", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.NEWBORN_IS_NULL);
        }
    }

    private void validateCertificateNumber(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Number");
        if (birthCertificateCommand.getCertificateNumber() == null || birthCertificateCommand.getCertificateNumber().isEmpty()) {
            bindingResult.rejectValue("certificateNumber", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.CERTIFICATE_NUMBER_IS_NULL);
        }
    }

    private void validateCertificateSource(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Source");
        if (birthCertificateCommand.getCertificateSource() == null ) {
            bindingResult.rejectValue("certificateSource", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.SOURCE_IS_NULL);
        }
    }

    private void validateCertificateType(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Type");
        if (birthCertificateCommand.getCertificateType() == null ) {
            bindingResult.rejectValue("certificateType", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.CERTIFICATE_TYPE_IS_NULL);
        }
    }

    private void validateCertificateDate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Date");
        if (birthCertificateCommand.getCertificateDate() == null || birthCertificateCommand.getCertificateDate().isEmpty()) {
            bindingResult.rejectValue("certificateDate", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.CERTIFICATE_DATE_IS_NULL);
        } else {
            try {
                LocalDate.parse(birthCertificateCommand.getCertificateDate(), ApplicationConstants.FORMATTER);
            } catch (Exception e) {
                bindingResult.rejectValue("certificateDate", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.DATE_IS_INVALID);
            }
        }
    }

    private void validateCertificateLegitimateDate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth Certificate valid date");
        try {
            LocalDate testDate = LocalDate.parse(birthCertificateCommand.getCertificateDate(), ApplicationConstants.FORMATTER);
            if (testDate.isAfter(LocalDate.now())) {
                bindingResult.rejectValue("certificateDate", ApplicationConstants.EMPTY_STRING,
                        null,
                        ValidationConstants.DATE_IN_FUTURE);
            }
        } catch (Exception e) {
            logger.debug("Error trapped in  birth Certificate valid date");
        }
    }


}

