/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;

@Component
public class BirthCertificateCommandValidator {
    private static final Logger logger = LogManager.getLogger(BirthCertificateCommandValidator.class);

    private final BirthCertificateCommandPartOneValidator partOneValidator;
    private final BirthCertificateCommandPartTwoValidator partTwoValidator;

    public BirthCertificateCommandValidator(BirthCertificateCommandPartOneValidator partOneValidator,
                                            BirthCertificateCommandPartTwoValidator partTwoValidator) {
        this.partOneValidator = partOneValidator;
        this.partTwoValidator = partTwoValidator;
    }


    public void validate(BirthCertificateCommand birthCertificateCommand, BindingResult bindingResult) {
        logger.debug("Validating birth certificate command");

        partOneValidator.validate(birthCertificateCommand, bindingResult);
        partTwoValidator.validate(birthCertificateCommand, bindingResult);
    }



}

