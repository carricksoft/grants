/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

@SuppressWarnings("unused")
@Component
public class AppendixTextCommandValidatorImpl implements AppendixTextCommandValidator {

    private static final Logger logger = LogManager.getLogger(AppendixTextCommandValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public AppendixTextCommandValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(AppendixTextCommand appendixTextCommand, BindingResult bindingResult) {
        logger.debug("PersonTextCommandValidator::validate");
        validateOrder(appendixTextCommand.getOrder(), bindingResult);
        validateLevel(appendixTextCommand.getLevel(), bindingResult);
    }

    private void validateLevel(String level, BindingResult bindingResult) {
        logger.debug("PersonTextCommandValidator::validateLevel");
        validateTypes.validateIntegerRange(level, ApplicationConstants.LATEX_BOOK, ApplicationConstants.LATEX_SUB_PARAGRAPH, "level",
                ValidationConstants.LEVEL_IS_NULL, ValidationConstants.LEVEL_IS_INVALID, ValidationConstants.LEVEL_IS_OUTSIDE_LIMITS, bindingResult);
    }

    private void validateOrder(String order, BindingResult bindingResult) {
        logger.debug("PersonTextCommandValidator::validateOrder");
        validateTypes.validateNonNegativeInteger(order, "order",ValidationConstants.ORDER_IS_NULL,
                ValidationConstants.ORDER_IS_INVALID, ValidationConstants.ORDER_IS_NEGATIVE,bindingResult);
    }


}

