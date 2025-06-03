/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;

@Component
public class BirthCertificateCommandPartThreeValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartThreeValidator.class);

    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part two)");

        validateSex(birthCertificateCommand, bindingResult);
        validateWhenBorn(birthCertificateCommand, bindingResult);
        validateWhereBorn(birthCertificateCommand, bindingResult);
    }


    private void validateWhereBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating where born");
        if (birthCertificateCommand.getWhereBorn() == null || birthCertificateCommand.getWhereBorn().isEmpty()) {
            bindingResult.rejectValue("whereBorn", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.WHERE_BORN_IS_NULL);
        }
    }


    private void validateSex(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating sex");
        if (birthCertificateCommand.getSex() == null ) {
            bindingResult.rejectValue("sex", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.SEX_IS_NULL);
        }
    }

    private void validateWhenBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        String[] parts = birthCertificateCommand.getWhenBorn().split("/");
        if (parts.length != 3) {
            bindingResult.rejectValue("whenBorn", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.WHEN_BORN_INCORRECT_FORMAT);
        } else {
            validateInteger(parts[0], 1, 31, ValidationConstants.WHEN_BORN_INCORRECT_FORMAT, "whenBorn", bindingResult);
            validateInteger(parts[1], 1, 12, ValidationConstants.WHEN_BORN_INCORRECT_FORMAT, "whenBorn", bindingResult);
            validateYearAndTime(parts[2], bindingResult);
        }
    }


    @SuppressWarnings("DuplicatedCode")
    private void validateInteger(String part, int low, int high, String validationConstant, String field, BindingResult bindingResult) {
        boolean invalid = false;
        try {
            int value = Integer.parseInt(part);
            if (value < low || value > high) {
                invalid = true;
            }
        } catch (RuntimeException e) {
            invalid = true;
        }
        if (invalid) {
            bindingResult.rejectValue(field, ApplicationConstants.EMPTY_STRING,
                    null,
                    validationConstant);
        }
    }

    private void validateYearAndTime(String string, BindingResult bindingResult) {
        String[] parts = string.split(" ");
        if (parts.length != 2) {
            bindingResult.rejectValue("whenBorn", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.WHEN_BORN_INCORRECT_FORMAT);
        }
        else {
            validateInteger(parts[0], 1600, 2029, ValidationConstants.WHEN_BORN_INCORRECT_FORMAT, "whenBorn", bindingResult);
            validateTime(parts[1], "whenBorn", bindingResult);
        }
    }

    private void validateTime(String time, String whenBorn, BindingResult bindingResult) {
        String[] parts = time.split(":");
        if (parts.length != 2) {
            bindingResult.rejectValue("whenBorn", ApplicationConstants.EMPTY_STRING,
                    null,
                    ValidationConstants.WHEN_BORN_INCORRECT_FORMAT);
        } else {
            validateInteger(parts[0], 0, 24, ValidationConstants.WHEN_BORN_INCORRECT_FORMAT, "whenBorn", bindingResult);
            validateInteger(parts[1], 0, 59, ValidationConstants.WHEN_BORN_INCORRECT_FORMAT, "whenBorn", bindingResult);
        }
    }


}

