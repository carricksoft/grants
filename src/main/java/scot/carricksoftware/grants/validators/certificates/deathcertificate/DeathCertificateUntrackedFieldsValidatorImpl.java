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
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;

@Component
public class DeathCertificateUntrackedFieldsValidatorImpl implements DeathCertificateUntrackedFieldsValidator {

    private static final Logger logger = LogManager.getLogger(DeathCertificateUntrackedFieldsValidatorImpl.class);

    private final ValidateTwoFieldTypes validateTwoFieldTypes;

    public DeathCertificateUntrackedFieldsValidatorImpl(ValidateTwoFieldTypes validateTwoFieldTypes) {
        this.validateTwoFieldTypes = validateTwoFieldTypes;
    }

    @Override
    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        validateUntrackedWhereDied(deathCertificateCommand, bindingResult);
    }

    @Override
    public void validateUntrackedWhereDied(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult){
        logger.debug("DeathCertificateUntrackedFieldsValidatorImpl::validateUntrackedWhereDied");
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(deathCertificateCommand.getWhereDied(),
                deathCertificateCommand.getUntrackedWhereDied(),
                "getWhereDied",
                "getUntrackedWhereDied",
                ValidationConstants.WHERE_BORN_AND_UNTRACKED_WHERE_BORN, bindingResult);
    }

}
