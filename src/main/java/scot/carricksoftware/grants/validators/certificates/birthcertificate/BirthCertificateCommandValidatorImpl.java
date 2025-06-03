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

@Component
public class BirthCertificateCommandValidatorImpl implements BirthCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandValidatorImpl.class);

    private final BirthCertificateCommandPartOneValidatorImpl partOneValidator;
    private final BirthCertificateCommandPartTwoValidatorImpl partTwoValidator;
    private final BirthCertificateCommandPartThreeValidatorImpl partThreeValidator;

    public BirthCertificateCommandValidatorImpl(BirthCertificateCommandPartOneValidatorImpl partOneValidator,
                                                BirthCertificateCommandPartTwoValidatorImpl partTwoValidator,
                                                BirthCertificateCommandPartThreeValidatorImpl partThreeValidator) {
        this.partOneValidator = partOneValidator;
        this.partTwoValidator = partTwoValidator;
        this.partThreeValidator = partThreeValidator;
    }


    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command");

        partOneValidator.validate(birthCertificateCommand, bindingResult);
        partTwoValidator.validate(birthCertificateCommand, bindingResult);
        partThreeValidator.validate(birthCertificateCommand, bindingResult);
    }



}

