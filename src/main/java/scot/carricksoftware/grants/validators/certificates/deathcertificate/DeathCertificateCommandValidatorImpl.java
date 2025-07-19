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
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;


@Component
public class DeathCertificateCommandValidatorImpl implements DeathCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(DeathCertificateCommandValidatorImpl.class);

    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating death certificate command");
        if (deathCertificateCommand.getDeceased() == null) {
            bindingResult.rejectValue("deceased", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.PERSON_IS_NULL);
        }
    }

}

