/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.marriagecertificate;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;


@Component
public class MarriageCertificateCommandValidatorImpl implements MarriageCertificateCommandValidator {

    final MarriageCertificateNullFieldsValidator marriageCertificateNullFieldsValidator;

    @SuppressWarnings("unused")
    final MarriageCertificateBaseFieldsValidator marriageCertificateBaseFieldsValidator;

    final MarriageCertificateUntrackedFieldsValidator marriageCertificateUntrackedFieldsValidator;


    public MarriageCertificateCommandValidatorImpl(MarriageCertificateNullFieldsValidator marriageCertificateNullFieldsValidator,
                                                   MarriageCertificateBaseFieldsValidator marriageCertificateBaseFieldsValidator,
                                                   MarriageCertificateUntrackedFieldsValidator marriageCertificateUntrackedFieldsValidator) {
        this.marriageCertificateNullFieldsValidator = marriageCertificateNullFieldsValidator;
        this.marriageCertificateBaseFieldsValidator = marriageCertificateBaseFieldsValidator;
        this.marriageCertificateUntrackedFieldsValidator = marriageCertificateUntrackedFieldsValidator;
    }


    @Override
    public void validate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult) {
        marriageCertificateNullFieldsValidator.validate(marriageCertificateCommand, bindingResult);
        marriageCertificateUntrackedFieldsValidator.validate(marriageCertificateCommand, bindingResult);
    }


}

