/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.divorcecertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTwoFieldTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;


@Component
public class DivorceCertificateCommandPeopleValidatorImpl implements DivorceCertificateCommandPeopleValidator {

    private static final Logger logger = LogManager.getLogger(DivorceCertificateCommandPeopleValidatorImpl.class);

    private final ValidateTypesImpl validateTypes;
    private final ValidateTwoFieldTypes validateTwoFieldTypes;

    public DivorceCertificateCommandPeopleValidatorImpl(ValidateTypesImpl validateTypes,
                                                        ValidateTwoFieldTypes validateTwoFieldTypes) {
        this.validateTypes = validateTypes;
        this.validateTwoFieldTypes = validateTwoFieldTypes;
    }

    @Override
    public void validate(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.info("DivorceCertificateCommandPeopleValidator::validate");
        validateFirstParty(divorceCertificateCommand, bindingResult);
        validateSecondParty(divorceCertificateCommand, bindingResult);
        validateDifferentParties(divorceCertificateCommand, bindingResult);
    }

    private void validateFirstParty(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificatePeopleValidator::validateFirstParty");
        validateTypes.validatePerson(divorceCertificateCommand.getFirstParty(), "firstParty", ValidationConstants.FIRST_PARTY_IS_NULL, bindingResult);
    }

    private void validateSecondParty(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificatePeopleValidator::validateSecondParty");
        validateTypes.validatePerson(divorceCertificateCommand.getSecondParty(), "secondParty", ValidationConstants.SECOND_PARTY_IS_NULL, bindingResult);
    }

    private void validateDifferentParties(DivorceCertificateCommand divorceCertificateCommand, BindingResult bindingResult) {
        logger.debug("DivorceCertificatePeopleValidator::validateDifferentParties");
        validateTwoFieldTypes.validateNotSamePerson(
                divorceCertificateCommand.getFirstParty(),
                divorceCertificateCommand.getSecondParty(),
                "firstParty",
                "secondParty",
                ValidationConstants.SAME_TWO_PARTIES, bindingResult);
    }
}

