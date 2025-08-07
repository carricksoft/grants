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
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

@Component
public class MarriageCertificateBaseFieldsValidatorImpl implements MarriageCertificateBaseFieldsValidator {

    private static final Logger logger = LogManager.getLogger(MarriageCertificateBaseFieldsValidatorImpl.class);

    private final ValidateTypesImpl validateTypes;
    private final ValidateDateTypes validateDateTypes;

    public MarriageCertificateBaseFieldsValidatorImpl(ValidateTypesImpl validateTypes, ValidateDateTypes validateDateTypes) {
        this.validateTypes = validateTypes;
        this.validateDateTypes = validateDateTypes;
    }

    @Override
    public void validate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        validateCertificateNumber(marriageCertificateCommand, bindingResult);
        validateCertificateType(marriageCertificateCommand, bindingResult);
        validateCertificateDate(marriageCertificateCommand, bindingResult);
        validateCertificateSource(marriageCertificateCommand, bindingResult);
        validateRegistrationAuthority(marriageCertificateCommand, bindingResult);
        validateVolume(marriageCertificateCommand, bindingResult);
        validateNumber(marriageCertificateCommand, bindingResult);
    }


    private void validateCertificateNumber(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateBaseFieldsValidator::validateCertificateNumber");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getCertificateNumber(), "certificateNumber",ValidationConstants.CERTIFICATE_NUMBER_IS_NULL, bindingResult);
    }

    private void validateVolume(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateBaseFieldsValidator::validateVolume");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getVolume(), "volume",ValidationConstants.REGISTRATION_VOLUME_IS_NULL, bindingResult);
    }

    private void validateNumber(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateBaseFieldsValidator::validateNumber");
        validateTypes.validateNullOrEmptyString(marriageCertificateCommand.getNumber(), "number",ValidationConstants.NUMBER_IS_NULL, bindingResult);
    }
    
    private void validateCertificateSource(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateBaseFieldsValidator::validateCertificateSource");
        validateTypes.validateOrganisation(marriageCertificateCommand.getCertificateSource(), "certificateSource", ValidationConstants.CERTIFICATE_SOURCE_IS_NULL, bindingResult);
    }

    private void validateRegistrationAuthority(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateBaseFieldsValidator::validateRegistrationAuthority");
        validateTypes.validateOrganisation(marriageCertificateCommand.getRegistrationAuthority(), "registrationAuthority",ValidationConstants.REGISTRATION_AUTHORITY_IS_NULL, bindingResult);
    }

    private void validateCertificateType(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateBaseFieldsValidator::validateCertificateType");
        validateTypes.validateCertificateType(marriageCertificateCommand.getCertificateType(), "certificateType",ValidationConstants.CERTIFICATE_TYPE_IS_NULL, bindingResult);
    }

    private void validateCertificateDate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        logger.debug("MarriageCertificateBaseFieldsValidator::validateCertificateDate");
        validateDateTypes.validatePastDate(marriageCertificateCommand.getCertificateDate(),
                "certificateDate",
                ValidationConstants.CERTIFICATE_DATE_IS_NULL,
                ValidationConstants.DATE_IS_INVALID,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }


}
