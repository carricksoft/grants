/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;


@Component
public class DeathCertificateCommandValidatorImpl implements DeathCertificateCommandValidator {

    final DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidator;

    final DeathCertificateUntrackedFieldsValidator deathCertificateUntrackedFieldsValidator;

    final DeathCertificateDateFieldsValidator deathCertificateDateFieldsValidator;

    public DeathCertificateCommandValidatorImpl(DeathCertificateNullFieldsValidator deathCertificateNullFieldsValidator, DeathCertificateUntrackedFieldsValidator deathCertificateUntrackedFieldsValidator, DeathCertificateDateFieldsValidator deathCertificateDateFieldsValidator) {
        this.deathCertificateNullFieldsValidator = deathCertificateNullFieldsValidator;
        this.deathCertificateUntrackedFieldsValidator = deathCertificateUntrackedFieldsValidator;
        this.deathCertificateDateFieldsValidator = deathCertificateDateFieldsValidator;
    }


    @Override
    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        deathCertificateNullFieldsValidator.validate(deathCertificateCommand, bindingResult);
        deathCertificateUntrackedFieldsValidator.validate(deathCertificateCommand, bindingResult);
        deathCertificateDateFieldsValidator.validate(deathCertificateCommand, bindingResult);
    }


}

