/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.marriagecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;

@Component
public class MarriageCertificateUntrackedFieldsValidatorImpl implements MarriageCertificateUntrackedFieldsValidator {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateUntrackedFieldsValidatorImpl.class);

    private final ValidateTwoFieldTypes validateTwoFieldTypes;

    public MarriageCertificateUntrackedFieldsValidatorImpl(ValidateTwoFieldTypes validateTwoFieldTypes) {
        this.validateTwoFieldTypes = validateTwoFieldTypes;
    }

    @Override
    public void validate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validate");
        validateUntrackedWhereMarried(marriageCertificateCommand, bindingResult);
        validateGroomUntrackedResidence(marriageCertificateCommand, bindingResult);
        validateBrideUntrackedResidence(marriageCertificateCommand, bindingResult);
        validateGroomUntrackedFather(marriageCertificateCommand, bindingResult);
        validateBrideUntrackedFather(marriageCertificateCommand, bindingResult);
        validateUntrackedFirstWitness(marriageCertificateCommand, bindingResult);
        validateUntrackedSecondWitness(marriageCertificateCommand, bindingResult);
    }

    @Override
    public void validateUntrackedWhereMarried(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validateUntrackedWhereMarried");
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(marriageCertificateCommand.getWhereMarried(),
                marriageCertificateCommand.getUntrackedWhereMarried(),
                "whereMarried",
                "untrackedWhereMarried",
                ValidationConstants.WHERE_MARRIED_AND_UNTRACKED_WHERE_MARRIED,
                bindingResult);
    }

    @Override
    public void validateGroomUntrackedResidence(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validateGroomUntrackedResidence");
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(marriageCertificateCommand.getGroomUsualResidence(),
                marriageCertificateCommand.getGroomUntrackedResidence(),
                "groomUsualResidence",
                "untrackedGroomResidence",
                ValidationConstants.GROOM_USUAL_RESIDENCE_AND_UNTRACKED_USUAL_RESIDENCE,
                bindingResult);
    }

    @Override
    public void validateBrideUntrackedResidence(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validateBrideUntrackedResidence");
        validateTwoFieldTypes.validatePlaceAndUntrackedPlace(marriageCertificateCommand.getBrideUsualResidence(),
                marriageCertificateCommand.getBrideUntrackedResidence(),
                "groomUsualResidence",
                "untrackedGroomResidence",
                ValidationConstants.BRIDE_USUAL_RESIDENCE_AND_UNTRACKED_USUAL_RESIDENCE,
                bindingResult);
    }

    @Override
    public void validateGroomUntrackedFather(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validateGroomUntrackedFather");
        validateTwoFieldTypes.validatePersonAndUntrackedPerson(marriageCertificateCommand.getGroomFather(),
                marriageCertificateCommand.getGroomUntrackedFather(),
                "groomFather",
                "groomUntrackedFather",
                ValidationConstants.GROOM_FATHER_AND_UNTRACKED_FATHER,
                bindingResult);
    }

    @Override
    public void validateBrideUntrackedFather(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validateBrideUntrackedFather");
        validateTwoFieldTypes.validatePersonAndUntrackedPerson(marriageCertificateCommand.getBrideFather(),
                marriageCertificateCommand.getBrideUntrackedFather(),
                "brideFather",
                "brideUntrackedFather",
                ValidationConstants.BRIDE_FATHER_AND_UNTRACKED_FATHER,
                bindingResult);
    }

    @Override
    public void validateUntrackedFirstWitness(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validateUntrackedFirstWitness");
        validateTwoFieldTypes.validatePersonAndUntrackedPerson(marriageCertificateCommand.getFirstWitness(),
                marriageCertificateCommand.getUntrackedFirstWitness(),
                "firstWitness",
                "untrackedFirstWitness",
                ValidationConstants.WITNESS_AND_UNTRACKED_FIRST_WITNESS,
                bindingResult);
    }

    @Override
    public void validateUntrackedSecondWitness(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateUntrackedFieldsValidatorImp::validateUntrackedSecondWitness");
        validateTwoFieldTypes.validatePersonAndUntrackedPerson(marriageCertificateCommand.getSecondWitness(),
                marriageCertificateCommand.getUntrackedSecondWitness(),
                "firstWitness",
                "untrackedFirstWitness",
                ValidationConstants.WITNESS_AND_UNTRACKED_SECOND_WITNESS,
                bindingResult);
    }
}
