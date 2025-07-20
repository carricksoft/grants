/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;


import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;

public interface DeathCertificateUntrackedFieldsValidator {

    @SuppressWarnings("unused")
    void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);

    void validateUntrackedWhereDied(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);

    void validateUsualResidence(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);

    void validateSpouse(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);

    void validateFather(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);

    void validateMother(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);

    void validateInformant(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);
}

