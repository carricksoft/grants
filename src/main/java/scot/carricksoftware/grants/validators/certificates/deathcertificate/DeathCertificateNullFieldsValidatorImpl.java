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
import scot.carricksoftware.grants.validators.helpers.ValidateDateTypes;
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

@Component
public class DeathCertificateNullFieldsValidatorImpl implements DeathCertificateNullFieldsValidator {

    private static final Logger logger = LogManager.getLogger(DeathCertificateNullFieldsValidatorImpl.class);

    private final ValidateTypesImpl validateTypes;
    private final ValidateDateTypes validateDateTypes;

    public DeathCertificateNullFieldsValidatorImpl(ValidateTypesImpl validateTypes, ValidateDateTypes validateDateTypes) {
        this.validateTypes = validateTypes;
        this.validateDateTypes = validateDateTypes;
    }

    @Override
    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        validateCertificateNumber(deathCertificateCommand, bindingResult);
        validateCertificateType(deathCertificateCommand, bindingResult);
        validateCertificateDate(deathCertificateCommand, bindingResult);
        validateVolume(deathCertificateCommand, bindingResult);
        validateNumber(deathCertificateCommand, bindingResult);
        validateDeceased(deathCertificateCommand, bindingResult);
        validateSex(deathCertificateCommand, bindingResult);
        validateCauseOfDeath(deathCertificateCommand, bindingResult);
        validateInformantQualification(deathCertificateCommand, bindingResult);
        validateCertificateSource(deathCertificateCommand, bindingResult);
        validateRegistrationAuthority(deathCertificateCommand, bindingResult);
        validateWhenDied(deathCertificateCommand, bindingResult);
    }

    private void validateWhenDied(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateWhenDied");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getWhenDied(), "whenDied", ValidationConstants.WHEN_DIED_IS_NULL, bindingResult);
    }

    private void validateDeceased(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateDeceased");
        validateTypes.validatePerson(deathCertificateCommand.getDeceased(), "deceased", ValidationConstants.DECEASED_IS_NULL, bindingResult);
    }

    private void validateCertificateNumber(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateCertificateNumber");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getCertificateNumber(), "certificateNumber",ValidationConstants.CERTIFICATE_NUMBER_IS_NULL, bindingResult);
    }

    private void validateVolume(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateVolume");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getVolume(), "volume",ValidationConstants.REGISTRATION_VOLUME_IS_NULL, bindingResult);
    }

    private void validateNumber(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateNumber");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getNumber(), "number",ValidationConstants.NUMBER_IS_NULL, bindingResult);
    }

    private void validateCauseOfDeath(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateCauseOfDeath");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getCauseOfDeath(), "causeOfDeath",ValidationConstants.CAUSE_OF_DEATH_IS_NULL, bindingResult);
    }

    private void validateInformantQualification(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateInformantQualification");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getInformantQualification(), "informantQualification",ValidationConstants.INFORMANT_QUALIFICATION_IS_NULL, bindingResult);
    }

    private void validateSex(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateSex");
        validateTypes.validateSex(deathCertificateCommand.getSex(), "sex",ValidationConstants.SEX_IS_NULL, bindingResult);
    }

    private void validateCertificateSource(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateCertificateSource");
        validateTypes.validateOrganisation(deathCertificateCommand.getCertificateSource(), "certificateSource", ValidationConstants.CERTIFICATE_SOURCE_IS_NULL, bindingResult);
    }

    private void validateRegistrationAuthority(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateRegistrationAuthority");
        validateTypes.validateOrganisation(deathCertificateCommand.getRegistrationAuthority(), "registrationAuthority",ValidationConstants.REGISTRATION_AUTHORITY_IS_NULL, bindingResult);
    }

    private void validateCertificateType(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateCertificateType");
        validateTypes.validateCertificateType(deathCertificateCommand.getCertificateType(), "certificateType",ValidationConstants.CERTIFICATE_TYPE_IS_NULL, bindingResult);
    }

    private void validateCertificateDate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate Certificate Date");
        validateDateTypes.validatePastDate(deathCertificateCommand.getCertificateDate(),
                "certificateDate",
                ValidationConstants.CERTIFICATE_DATE_IS_NULL,
                ValidationConstants.DATE_IS_INVALID,
                ValidationConstants.DATE_IN_FUTURE,
                bindingResult);
    }



}
