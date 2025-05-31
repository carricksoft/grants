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
public class BirthCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandValidator.class);

    @SuppressWarnings("unused")
    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command");

        validateNewBorn(birthCertificateCommand, bindingResult);
        validateCertificateNumber(birthCertificateCommand, bindingResult);
        validateCertificateIssuedAt(birthCertificateCommand, bindingResult);
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

    private void validateCertificateIssuedAt(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Issued At");
        if (birthCertificateCommand.getCertificateSource() == null ) {
            bindingResult.rejectValue("certificateIssuedAt", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.ISSUED_AT_IS_NULL);
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

