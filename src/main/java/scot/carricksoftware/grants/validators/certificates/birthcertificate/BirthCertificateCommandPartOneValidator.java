/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.birthcertificate;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;


@Component
public interface BirthCertificateCommandPartOneValidator {


    void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult);
}

