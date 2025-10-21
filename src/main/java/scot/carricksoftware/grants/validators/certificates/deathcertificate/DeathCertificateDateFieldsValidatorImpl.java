/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;

@Component
public class DeathCertificateDateFieldsValidatorImpl implements DeathCertificateDateFieldsValidator {

    private static final Logger logger = LogManager.getLogger(DeathCertificateDateFieldsValidatorImpl.class);

    private final ValidateDateTypes validateDateTypes;

    public DeathCertificateDateFieldsValidatorImpl(ValidateDateTypes validateDateTypes) {
        this.validateDateTypes = validateDateTypes;
    }

    @Override
    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        validateCertificateDate(deathCertificateCommand, bindingResult);
        validateWhenDied(deathCertificateCommand, bindingResult);
    }

    private void validateCertificateDate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateCertificateDate");
        validateDateTypes.validatePastDate(deathCertificateCommand.getCertificateDate(),
                "certificateDate",
                ValidationConstants.CERTIFICATE_DATE_IS_NULL,
                ValidationConstants.DATE_IS_INVALID,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }


    private void validateWhenDied(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateWhenDied");
        validateDateTypes.validatePastDate(deathCertificateCommand.getWhenDied(),
                "whenDied",
                ValidationConstants.WHEN_DIED_IS_NULL,
                ValidationConstants.WHEN_DIED_IS_INVALID,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }

}
