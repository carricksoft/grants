/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;


@Component
public class BirthCertificateCommandPartThreeValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartThreeValidator.class);

    private final ValidateTypes validateTypes;

    public BirthCertificateCommandPartThreeValidator(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part three)");

        validateSex(birthCertificateCommand, bindingResult);
        validateWhenBorn(birthCertificateCommand, bindingResult);
        validateWhereBorn(birthCertificateCommand, bindingResult);
    }

    private void validateWhereBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating where born");
        validateTypes.validateNullOrEmptyString(birthCertificateCommand.getWhereBorn(), "whereBorn", ValidationConstants.WHERE_BORN_IS_NULL, bindingResult);
    }

    private void validateSex(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating sex");
        validateTypes.validateSex(birthCertificateCommand.getSex(), "whereBorn", ValidationConstants.SEX_IS_NULL, bindingResult);
    }

    private void validateWhenBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating when born");
        validateTypes.validatePastDateAndTime(birthCertificateCommand.getWhenBorn(), "whereBorn", ValidationConstants.WHEN_BORN_IS_NULL, ValidationConstants.WHEN_BORN_INCORRECT_FORMAT, ValidationConstants.DATE_IN_FUTURE,bindingResult);
    }


}
