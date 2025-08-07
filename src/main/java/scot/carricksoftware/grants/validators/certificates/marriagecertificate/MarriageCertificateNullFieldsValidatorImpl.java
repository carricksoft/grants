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
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

@Component
public class MarriageCertificateNullFieldsValidatorImpl implements MarriageCertificateNullFieldsValidator {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateNullFieldsValidatorImpl.class);

    private final ValidateTypesImpl validateTypes;

    public MarriageCertificateNullFieldsValidatorImpl(ValidateTypesImpl validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        validateGroom(marriageCertificateCommand, bindingResult);
        validateBride(marriageCertificateCommand, bindingResult);
        validateGroomAge(marriageCertificateCommand, bindingResult);
        validateBrideAge(marriageCertificateCommand, bindingResult);
        validateGroomRank(marriageCertificateCommand, bindingResult);
        validateBrideRank(marriageCertificateCommand, bindingResult);
        validateGroomCondition(marriageCertificateCommand, bindingResult);
        validateBrideCondition(marriageCertificateCommand, bindingResult);
        validateWhenMarried(marriageCertificateCommand, bindingResult);
    }

    private void validateWhenMarried(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateWhenDied");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getWhenMarried(), "whenDied", ValidationConstants.WHEN_MARRIED_IS_NULL, bindingResult);
    }

    private void validateGroom(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroom");
        validateTypes.validatePerson(marriageCertificateCommand.getGroom(), "groom", ValidationConstants.GROOM_IS_NULL, bindingResult);
    }

    private void validateBride(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBride");
        validateTypes.validatePerson(marriageCertificateCommand.getGroom(), "bride", ValidationConstants.BRIDE_IS_NULL, bindingResult);
    }


    private void validateGroomAge(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroomAge");
        validateTypes.validatePerson(marriageCertificateCommand.getGroom(), "groomAge", ValidationConstants.GROOM_AGE_IS_NULL, bindingResult);
    }

    private void validateGroomRank(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroomRank");
        validateTypes.validatePerson(marriageCertificateCommand.getGroom(), "groomRank", ValidationConstants.GROOM_RANK_IS_NULL, bindingResult);
    }

    private void validateGroomCondition(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroomCondition");
        validateTypes.validatePerson(marriageCertificateCommand.getGroom(), "groomCondition", ValidationConstants.GROOM_CONDITION_IS_NULL, bindingResult);
    }

    private void validateBrideAge(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBrideAge");
        validateTypes.validatePerson(marriageCertificateCommand.getBride(), "brideAge", ValidationConstants.BRIDE_AGE_IS_NULL, bindingResult);
    }

    private void validateBrideRank(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBrideRank");
        validateTypes.validatePerson(marriageCertificateCommand.getBride(), "brideRank", ValidationConstants.BRIDE_RANK_IS_NULL, bindingResult);
    }

    private void validateBrideCondition(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBrideCondition");
        validateTypes.validatePerson(marriageCertificateCommand.getBride(), "brideCondition", ValidationConstants.BRIDE_CONDITION_IS_NULL, bindingResult);
    }



}
