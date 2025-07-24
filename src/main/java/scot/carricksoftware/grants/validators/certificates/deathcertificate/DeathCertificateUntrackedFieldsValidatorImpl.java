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
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;

@Component
public class DeathCertificateUntrackedFieldsValidatorImpl implements DeathCertificateUntrackedFieldsValidator {

    private static final Logger logger = LogManager.getLogger(DeathCertificateUntrackedFieldsValidatorImpl.class);

    private final ValidateTwoFieldTypes validateTwoFieldTypes;

    public DeathCertificateUntrackedFieldsValidatorImpl(ValidateTwoFieldTypes validateTwoFieldTypes) {
        this.validateTwoFieldTypes = validateTwoFieldTypes;
    }

    @Override
    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateUntrackedFieldsValidatorImpl::validate");
        validateUntrackedWhereDied(deathCertificateCommand, bindingResult);
        validateUsualResidence(deathCertificateCommand, bindingResult);
        validateSpouse(deathCertificateCommand, bindingResult);
        validateFather(deathCertificateCommand, bindingResult);
        validateMother(deathCertificateCommand, bindingResult);
        validateInformant(deathCertificateCommand, bindingResult);
    }

    @Override
    public void validateUntrackedWhereDied(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateUntrackedFieldsValidatorImp::validateUntrackedWhereDied");
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(deathCertificateCommand.getWhereDied(),
                deathCertificateCommand.getUntrackedWhereDied(),
                "whereDied",
                "untrackedWhereDied",
                ValidationConstants.WHERE_DIED_AND_UNTRACKED_WHERE_DIED,
                bindingResult);
    }

    @Override
    public void validateUsualResidence(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateUntrackedFieldsValidatorImp::validateUsualResidence");
        validateTwoFieldTypes.validateOptionalPlaceAndUntrackedPlace(deathCertificateCommand.getUsualResidence(),
                deathCertificateCommand.getUntrackedUsualResidence(),
                "usualResidence",
                "untrackedUsualResidence",
                ValidationConstants.USUAL_RESIDENCE_AND_UNTRACKED_USUAL_RESIDENCE,
                bindingResult);
    }

    @Override
    public void validateSpouse(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateUntrackedFieldsValidatorImp::validateSpouse");
        validateTwoFieldTypes.validateOptionalPersonAndUntrackedPerson(deathCertificateCommand.getSpouse(),
                deathCertificateCommand.getUntrackedSpouse(),
                "spouse",
                "untrackedSpouse",
                ValidationConstants.SPOUSE_AND_UNTRACKED_SPOUSE,
                bindingResult);
    }

    @Override
    public void validateFather(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateUntrackedFieldsValidatorImp::validateFather");
        validateTwoFieldTypes.validateOptionalPersonAndUntrackedPerson(deathCertificateCommand.getFather(),
                deathCertificateCommand.getUntrackedFather(),
                "father",
                "untrackedFather",
                ValidationConstants.FATHER_AND_UNTRACKED_FATHER_OPTIONAL,
                bindingResult);
    }

    @Override
    public void validateMother(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateUntrackedFieldsValidatorImp::validateMother");
        validateTwoFieldTypes.validateOptionalPersonAndUntrackedPerson(deathCertificateCommand.getMother(),
                deathCertificateCommand.getUntrackedMother(),
                "mother",
                "untrackedMother",
                ValidationConstants.MOTHER_AND_UNTRACKED_MOTHER,
                bindingResult);
    }

    @Override
    public void validateInformant(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateUntrackedFieldsValidatorImp::validateInformant");
        validateTwoFieldTypes.validatePersonAndUntrackedPerson(deathCertificateCommand.getInformant(),
                deathCertificateCommand.getUntrackedInformant(),
                "informant",
                "untrackedInformant",
                ValidationConstants.INFORMANT_AND_UNTRACKED_INFORMANT,
                bindingResult);
    }





}
