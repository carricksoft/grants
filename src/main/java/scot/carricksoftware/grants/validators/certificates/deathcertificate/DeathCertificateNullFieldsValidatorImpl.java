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
import scot.carricksoftware.grants.validators.helpers.ValidateTypesImpl;

@Component
public class DeathCertificateNullFieldsValidatorImpl implements DeathCertificateNullFieldsValidator {

    private static final Logger logger = LogManager.getLogger(DeathCertificateNullFieldsValidatorImpl.class);

    private final ValidateTypesImpl validateTypes;

    public DeathCertificateNullFieldsValidatorImpl(ValidateTypesImpl validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        validateCertificateNumber(deathCertificateCommand, bindingResult);
        validateVolume(deathCertificateCommand, bindingResult);
        validateNumber(deathCertificateCommand, bindingResult);
        validateDeceased(deathCertificateCommand, bindingResult);
        validateSex(deathCertificateCommand, bindingResult);
        validateCauseOfDeath(deathCertificateCommand, bindingResult);
        validateInformantQualification(deathCertificateCommand, bindingResult);
    }

    private void validateDeceased(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateDeceased");
        validateTypes.validatePerson(deathCertificateCommand.getDeceased(), "deceased", "Deceased cannot be null", bindingResult);
    }

    private void validateCertificateNumber(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateCertificateNumber");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getCertificateNumber(), "certificateNumber","Certificate number must exist", bindingResult);
    }

    private void validateVolume(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateVolume");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getVolume(), "volume","Volume must exist", bindingResult);
    }

    private void validateNumber(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateNumber");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getNumber(), "number","Number must exist", bindingResult);
    }

    private void validateCauseOfDeath(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateCauseOfDeath");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getCauseOfDeath(), "causeOfDeath","Cause of Death must exist", bindingResult);
    }

    private void validateInformantQualification(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateInformantQualification");
        validateTypes.validateNullOrEmptyString(deathCertificateCommand.getInformantQualification(), "informantQualification","Informant Qualification must exist", bindingResult);
    }

    private void validateSex(DeathCertificateCommand deathCertificateCommand, BindingResult bindingResult) {
        logger.debug("DeathCertificateNullFieldsValidator::validateSex");
        validateTypes.validateSex(deathCertificateCommand.getSex(), "sex","Sex cannot be null", bindingResult);
    }




}
