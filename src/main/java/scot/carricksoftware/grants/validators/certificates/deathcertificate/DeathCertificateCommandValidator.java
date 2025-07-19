/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;


import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;

public interface DeathCertificateCommandValidator {

    @SuppressWarnings("unused")
    void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult);
}

