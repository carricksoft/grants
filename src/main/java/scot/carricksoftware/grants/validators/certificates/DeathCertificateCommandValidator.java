/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.DeathCertificateCommand;


@Component
public class DeathCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(DeathCertificateCommandValidator.class);

    @SuppressWarnings("unused")
    public void validate(DeathCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
       logger.debug("Validating death certificate command");
    }


    
}

