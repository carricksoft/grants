/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;


@Component
public class DeathCertificateCommandValidatorImpl implements DeathCertificateCommandValidator {

    final DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidator;

    final ValidateTwoFieldTypes validateTwoFieldTypes;

    public DeathCertificateCommandValidatorImpl(DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidator, ValidateTwoFieldTypes validateTwoFieldTypes) {
        this.deathCertificateNullFieldsValidator = deathCertificateNullFieldsValidator;
        this.validateTwoFieldTypes = validateTwoFieldTypes;
    }


    @Override
    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        validateWhereDied(deathCertificateCommand, bindingResult);
        validateUsualResidence(deathCertificateCommand, bindingResult);
    }

    private void validateWhereDied(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(deathCertificateCommand.getWhereDied(), deathCertificateCommand.getUntrackedWhereDied(),
                "whereDied", "untrackedWhereDied", ValidationConstants.WHERE_DIED_AND_UNTRACKED_WHERE_DIED,bindingResult);
    }

    private void validateUsualResidence(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(deathCertificateCommand.getUsualResidence(), deathCertificateCommand.getUntrackedUsualResidence(),
                "usualResidence", "untrackedUsualResidence", ValidationConstants.USUAL_RESIDENCE_AND_UNTRACKED_USUAL_RESIDENCE,bindingResult);
    }

}

