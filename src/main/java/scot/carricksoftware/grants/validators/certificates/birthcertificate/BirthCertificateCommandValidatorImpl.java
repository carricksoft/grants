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

    private final BirthCertificateCommandPartOneValidator partOneValidator;
    private final BirthCertificateCommandPartTwoValidator partTwoValidator;
    private final BirthCertificateCommandPartThreeValidator partThreeValidator;

    public BirthCertificateCommandValidatorImpl(BirthCertificateCommandPartOneValidator partOneValidator,
                                                BirthCertificateCommandPartTwoValidator partTwoValidator,
                                                BirthCertificateCommandPartThreeValidator partThreeValidator) {
        this.partOneValidator = partOneValidator;
        this.partTwoValidator = partTwoValidator;
        this.partThreeValidator = partThreeValidator;
    }

    @Override
    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command");

        partOneValidator.validate(birthCertificateCommand, bindingResult);
        partTwoValidator.validate(birthCertificateCommand, bindingResult);
        partThreeValidator.validate(birthCertificateCommand, bindingResult);
    }


}

