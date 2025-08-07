/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.marriagecertificate;


import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;

public interface MarriageCertificateNullFieldsValidator {

    @SuppressWarnings("unused")
    void validate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);
}

