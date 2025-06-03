/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.deathcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;


@Component
public class MarriageCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(MarriageCertificateCommandValidator.class);

    @SuppressWarnings("unused")
    public void validate(@SuppressWarnings("unused") MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating death certificate command");
        validateBrideAndGroomInIsolation(marriageCertificateCommand, bindingResult);


        if (marriageCertificateCommand.getGroom() != null) {
            if (marriageCertificateCommand.getBride() != null) {
                validateBrideAndGroomTogether(marriageCertificateCommand, bindingResult);
            }
        }
    }

    private void validateBrideAndGroomInIsolation(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        if (marriageCertificateCommand.getBride() == null) {
            bindingResult.rejectValue("bride", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.BRIDE_IS_NULL);
        }
        if (marriageCertificateCommand.getGroom() == null) {
            bindingResult.rejectValue("groom", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.GROOM_IS_NULL);
        }
    }

    private void validateBrideAndGroomTogether(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        if (marriageCertificateCommand.getBride().equals(marriageCertificateCommand.getGroom())) {
            bindingResult.rejectValue("groom", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.SAME_BRIDE_AND_GROOM);
            bindingResult.rejectValue("bride", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.SAME_BRIDE_AND_GROOM);
        }
    }


}

