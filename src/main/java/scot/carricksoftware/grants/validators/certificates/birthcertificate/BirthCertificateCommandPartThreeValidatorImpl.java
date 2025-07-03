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
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;


@Component
public class BirthCertificateCommandPartThreeValidatorImpl implements BirthCertificateCommandPartThreeValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartThreeValidatorImpl.class);

    private final ValidateTypes validateTypes;
    private final ValidateTwoFieldTypes validateTwoFieldTypes;
    private final ValidateDateTypes validateDateTypes;

    public BirthCertificateCommandPartThreeValidatorImpl(ValidateTypes validateTypes, ValidateTwoFieldTypes validateTwoFieldTypes, ValidateDateTypes validateDateTypes) {
        this.validateTypes = validateTypes;
        this.validateTwoFieldTypes = validateTwoFieldTypes;
        this.validateDateTypes = validateDateTypes;
    }

    @Override
    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part three)");

        validateSex(birthCertificateCommand, bindingResult);
        validateWhenBorn(birthCertificateCommand, bindingResult);
        validateFatherAndUntrackedFather(birthCertificateCommand, bindingResult);
        validateWhereBornAndUntrackedWhereBorn(birthCertificateCommand, bindingResult);
        validateWhenRegistered(birthCertificateCommand, bindingResult);
        validateFatherUsualResidencesAndUntrackedFatherUsualResidence(birthCertificateCommand, bindingResult);
        validateMotherUsualResidencesAndUntrackedMotherUsualResidence(birthCertificateCommand, bindingResult);
    }

    private void validateSex(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating sex");
        validateTypes.validateSex(birthCertificateCommand.getSex(), "sex", ValidationConstants.SEX_IS_NULL, bindingResult);
    }

    private void validateWhenBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating when born");
        validateDateTypes.validatePastDateAndTime(birthCertificateCommand.getWhenBorn(),
                "whenBorn",
                ValidationConstants.WHEN_BORN_IS_NULL,
                ValidationConstants.WHEN_BORN_INCORRECT_FORMAT,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }

    private void validateFatherAndUntrackedFather(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating father and untracked father");
        validateTwoFieldTypes.validatePersonAndUntrackedPerson(birthCertificateCommand.getFather(),
                birthCertificateCommand.getUntrackedFather(), "father", "untrackedFather", ValidationConstants.FATHER_AND_UNTRACKED_FATHER,bindingResult);
    }

    private void validateWhereBornAndUntrackedWhereBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating where born and untracked where born");
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(birthCertificateCommand.getWhereBorn(), birthCertificateCommand.getUntrackedWhereBorn(),
                "whereBorn", "untrackedWhereBorn", ValidationConstants.WHERE_BORN_AND_UNTRACKED_WHERE_BORN,bindingResult);
    }

    private void validateFatherUsualResidencesAndUntrackedFatherUsualResidence(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating father Usual Residence and untracked usual residence");
        validateTwoFieldTypes.validateOptionalPlaceAndUntrackedPlace(birthCertificateCommand.getFatherUsualResidence(), birthCertificateCommand.getUntrackedFatherUsualResidence(),
                "fatherUsualResidence", "untrackedFatherUsualResidence", ValidationConstants.FATHER_USUAL_RESIDENCE_AND_UNTRACKED_FATHER_USUAL_RESIDENCE,bindingResult);
    }

    private void validateMotherUsualResidencesAndUntrackedMotherUsualResidence(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating mother Usual Residence and untracked usual residence");
        validateTwoFieldTypes.validateOptionalPlaceAndUntrackedPlace(birthCertificateCommand.getMotherUsualResidence(), birthCertificateCommand.getUntrackedMotherUsualResidence(),
                "motherUsualResidence", "untrackedMotherUsualResidence", ValidationConstants.MOTHER_USUAL_RESIDENCE_AND_UNTRACKED_MOTHER_USUAL_RESIDENCE,bindingResult);
    }

    private void validateWhenRegistered(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Registration Date");
        validateDateTypes.validatePastDate(birthCertificateCommand.getWhenRegistered(),
                "whenRegistered",
                ValidationConstants.WHEN_REGISTERED_DATE_IS_NULL,
                ValidationConstants.WHEN_REGISTERED_DATE_IS_INVALID,
                ValidationConstants.WHEN_REGISTERED_DATE_IN_FUTURE,
                bindingResult);
    }

}
