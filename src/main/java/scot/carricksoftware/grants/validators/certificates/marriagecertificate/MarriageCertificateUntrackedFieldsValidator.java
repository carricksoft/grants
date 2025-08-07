/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.validators.certificates.marriagecertificate;


import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;

public interface MarriageCertificateUntrackedFieldsValidator {

    @SuppressWarnings("unused")
    void validate(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);

    @SuppressWarnings("unused")
    void validateUntrackedWhereMarried(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);

    @SuppressWarnings("unused")
    void validateGroomUntrackedResidence(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);

    @SuppressWarnings("unused")
    void validateBrideUntrackedResidence(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);

    @SuppressWarnings("unused")
    void validateGroomUntrackedFather(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);

    @SuppressWarnings("unused")
    void validateBrideUntrackedFather(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);

    @SuppressWarnings("unused")
    void validateUntrackedFirstWitness(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);

    @SuppressWarnings("unused")
    void validateUntrackedSecondWitness(MarriageCertificateCommand marriageCertificateCommand, BindingResult bindingResult);
}

