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
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;


@Component
public class DivorceCertificateCommandDatesValidatorImpl implements DivorceCertificateCommandDatesValidator {

    private static final Logger logger = LogManager.getLogger(DivorceCertificateCommandDatesValidatorImpl.class);

    private final ValidateDateTypes validateDateTypes;

    public DivorceCertificateCommandDatesValidatorImpl(ValidateDateTypes validateDateTypes) {
        this.validateDateTypes = validateDateTypes;
    }

    @Override
    public void validate(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificateCommandPeopleValidator::validate");
        validateFirstPartyDate(divorceCertificateCommand, bindingResult);
        validateSecondPartyDate(divorceCertificateCommand, bindingResult);
        validateRegisteredDate(divorceCertificateCommand, bindingResult);
    }

    private void validateFirstPartyDate(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificateBaseCommandDatesValidator::validateFirstPartyDate");
        validateDateTypes.validatePastDate(divorceCertificateCommand.getFirstPartyDate(),
                "firstPartyDate",
                ValidationConstants.FIRST_PARTY_DATE_IS_NULL,
                ValidationConstants.FIRST_PARTY_DATE_INVALID_FORMAT,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }

    private void validateSecondPartyDate(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificateBaseCommandDatesValidator::validateSecondPartyDate");
        validateDateTypes.validatePastDate(divorceCertificateCommand.getSecondPartyDate(),
                "secondPartyDate",
                ValidationConstants.SECOND_PARTY_DATE_IS_NULL,
                ValidationConstants.SECOND_PARTY_DATE_INVALID_FORMAT,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }

    private void validateRegisteredDate(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificateBaseCommandDatesValidator::validateRegisteredDate");
        validateDateTypes.validatePastDate(divorceCertificateCommand.getRegisteredDate(),
                "registeredDate",
                ValidationConstants.REGISTERED_DATE_IS_NULL,
                ValidationConstants.REGISTERED_DATE_INVALID_FORMAT,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }
}

