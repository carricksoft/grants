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
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

@Component
public class MarriageCertificateNullFieldsValidatorImpl implements MarriageCertificateNullFieldsValidator {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateNullFieldsValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public MarriageCertificateNullFieldsValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }


    @Override
    public void validate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        validateGroom(marriageCertificateCommand, bindingResult);
        validateBride(marriageCertificateCommand, bindingResult);
        validateBrideCondition(marriageCertificateCommand, bindingResult);
        validateBrideRank(marriageCertificateCommand, bindingResult);
        validateGroomAge(marriageCertificateCommand, bindingResult);
        validateBrideAge(marriageCertificateCommand, bindingResult);
        validateGroomRank(marriageCertificateCommand, bindingResult);
        validateGroomCondition(marriageCertificateCommand, bindingResult);
        validateGroomFatherRank(marriageCertificateCommand, bindingResult);
        validateBrideFatherRank(marriageCertificateCommand, bindingResult);
    }

    private void validateGroom(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroom");
        validateTypes.validatePerson(marriageCertificateCommand.getGroom(), "groom", ValidationConstants.GROOM_IS_NULL, bindingResult);
    }

    private void validateBride(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBride");
        validateTypes.validatePerson(marriageCertificateCommand.getBride(), "bride", ValidationConstants.BRIDE_IS_NULL, bindingResult);
    }

    private void validateGroomAge(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroomAge");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getGroomAge(), "groomAge", ValidationConstants.GROOM_AGE_IS_NULL, bindingResult);
    }

    private void validateGroomRank(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroomRank");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getGroomRank(), "groomRank", ValidationConstants.GROOM_RANK_IS_NULL, bindingResult);
    }

    private void validateGroomCondition(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroomCondition");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getGroomCondition(), "groomCondition", ValidationConstants.GROOM_CONDITION_IS_NULL, bindingResult);
    }

    private void validateBrideAge(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBrideAge");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getBrideAge(), "brideAge", ValidationConstants.BRIDE_AGE_IS_NULL, bindingResult);
    }

    private void validateBrideRank(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBrideRank");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getBrideRank(), "brideRank", ValidationConstants.BRIDE_RANK_IS_NULL, bindingResult);
    }

    private void validateBrideCondition(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBrideCondition");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getBrideCondition(), "brideCondition", ValidationConstants.BRIDE_CONDITION_IS_NULL, bindingResult);
    }

    private void validateBrideFatherRank(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateBrideFatherRank");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getBrideFatherRank(), "brideFatherRank", ValidationConstants.BRIDE_FATHER_RANK_IS_NULL, bindingResult);
    }

    private void validateGroomFatherRank(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateNullFieldsValidator::validateGroomFatherRank");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getGroomFatherRank(), "groomFatherRank", ValidationConstants.GROOM_FATHER_RANK_IS_NULL, bindingResult);
    }




}
