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
public class BirthCertificateCommandPartOneValidatorImpl implements BirthCertificateCommandPartOneValidator {

    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandPartOneValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public BirthCertificateCommandPartOneValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command (part one)");

        validateNewBorn(birthCertificateCommand, bindingResult);
        validateCertificateNumber(birthCertificateCommand, bindingResult);
        validateCertificateSource(birthCertificateCommand, bindingResult);
        validateCertificateType(birthCertificateCommand, bindingResult);
        validateCertificateDate(birthCertificateCommand, bindingResult);
        validateMother(birthCertificateCommand, bindingResult);
    }

    private void validateNewBorn(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate newBorn");
        validateTypes.validatePerson(birthCertificateCommand.getNewBorn(), "newBorn", ValidationConstants.NEWBORN_IS_NULL, bindingResult);
    }


    private void validateCertificateNumber(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Number");
        validateTypes.validateNullOrEmptyString(birthCertificateCommand.getCertificateNumber(), "certificateNumber", ValidationConstants.CERTIFICATE_NUMBER_IS_NULL, bindingResult);
    }

    private void validateCertificateSource(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Source");
        validateTypes.validateOrganisation(birthCertificateCommand.getCertificateSource(), "certificateSource", ValidationConstants.CERTIFICATE_SOURCE_IS_NULL, bindingResult);
    }

    private void validateCertificateType(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Type");
        validateTypes.validateCertificateType(birthCertificateCommand.getCertificateType(), "certificateType", ValidationConstants.CERTIFICATE_TYPE_IS_NULL, bindingResult);
    }

    private void validateCertificateDate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Date");
        validateTypes.validatePastDate(birthCertificateCommand.getCertificateDate(),
                "certificateDate",
                ValidationConstants.CERTIFICATE_DATE_IS_NULL,
                ValidationConstants.DATE_IS_INVALID,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }

    private void validateMother(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Mother");
        validateTypes.validatePerson(birthCertificateCommand.getMother(), "mother", ValidationConstants.MOTHER_IS_NULL, bindingResult);
    }

}

