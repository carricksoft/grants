/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.birthcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;


@Component
public class BirthCertificateCommandPartThreeValidatorImpl implements BirthCertificateCommandPartThreeValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartThreeValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public BirthCertificateCommandPartThreeValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part three)");

        validateSex(birthCertificateCommand, bindingResult);
        validateWhenBorn(birthCertificateCommand, bindingResult);
        validateFatherAndUntrackedFather(birthCertificateCommand, bindingResult);
        validateWhereBornAndUntrackedWhereBorn(birthCertificateCommand, bindingResult);
    }


    private void validateSex(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating sex");
        validateTypes.validateSex(birthCertificateCommand.getSex(), "sex", ValidationConstants.SEX_IS_NULL, bindingResult);
    }

    private void validateWhenBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating when born");
        validateTypes.validatePastDateAndTime(birthCertificateCommand.getWhenBorn(), "whenBorn", ValidationConstants.WHEN_BORN_IS_NULL, ValidationConstants.WHEN_BORN_INCORRECT_FORMAT, ValidationConstants.DATE_IN_FUTURE,bindingResult);
    }

    private void validateFatherAndUntrackedFather(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating father and untracked father");
        validateTypes.validatePersonAndUntrackedPerson(birthCertificateCommand.getFather(), birthCertificateCommand.getUntrackedFather(), "father", "untrackedFather", ValidationConstants.FATHER_AND_UNTRACKED_FATHER,bindingResult);
    }

    private void validateWhereBornAndUntrackedWhereBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating where born and untracked where born");
        validateTypes.validatePlaceAndUntrackedPlace(birthCertificateCommand.getWhereBorn(), birthCertificateCommand.getUntrackedWhereBorn(),
                "whereBorn", "untrackedWhereBorn", ValidationConstants.WHERE_BORN_AND_UNTRACKED_WHERE_BORN,bindingResult);
    }

}
