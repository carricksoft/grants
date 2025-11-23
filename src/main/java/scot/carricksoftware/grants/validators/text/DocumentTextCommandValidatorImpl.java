/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

@SuppressWarnings("unused")
@Component
public class DocumentTextCommandValidatorImpl implements DocumentTextCommandValidator {

    private static final Logger logger = LogManager.getLogger(DocumentTextCommandValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public DocumentTextCommandValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }



    @Override
    public void validate(DocumentTextCommand documentTextCommand, BindingResult bindingResult) {
        logger.debug("DocumentTextCommandValidator::validate");
        validateOrder(documentTextCommand.getOrder(), bindingResult);
        validateLevel(documentTextCommand.getLevel(), bindingResult);
    }

    private void validateLevel(String integerString, BindingResult bindingResult) {
        logger.debug("DocumentImageCommandValidator::validateLevel");
        validateTypes.validateIntegerAsteriskRange(integerString,
                ApplicationConstants.LATEX_BOOK,
                ApplicationConstants.LATEX_SUB_PARAGRAPH, "level",
                ValidationConstants.LEVEL_IS_NULL,
                ValidationConstants.LEVEL_IS_INVALID,
                ValidationConstants.LEVEL_IS_OUTSIDE_LIMITS,
                bindingResult);
    }


    private void validateOrder(String order, BindingResult bindingResult) {
        logger.debug("PersonTextCommandValidator::validateOrder");
        validateTypes.validateNonNegativeInteger(order, "order",ValidationConstants.ORDER_IS_NULL,
                ValidationConstants.ORDER_IS_INVALID, ValidationConstants.ORDER_IS_NEGATIVE,bindingResult);
    }


}

