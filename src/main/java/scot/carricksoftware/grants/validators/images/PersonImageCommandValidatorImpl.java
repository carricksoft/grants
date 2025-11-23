/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

@SuppressWarnings("unused")
@Component
public class PersonImageCommandValidatorImpl implements PersonImageCommandValidator {

    private static final Logger logger = LogManager.getLogger(PersonImageCommandValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public PersonImageCommandValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(PersonImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validate");
        validatePerson(imageCommand, bindingResult);
        validateImage(imageCommand, bindingResult);
        validateOrder(imageCommand, bindingResult);
        validateLevel(imageCommand.getLevel(), bindingResult);
        validateWidth(imageCommand, bindingResult);
        validateHeight(imageCommand, bindingResult);
    }

    private void validateWidth(PersonImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateWidth");
        validateTypes.validateIntegerRange(imageCommand.getWidth(),
                ApplicationConstants.MINIMUM_IMAGE_WIDTH,
                ApplicationConstants.MAXIMUM_IMAGE_WIDTH,
                "width",
                ValidationConstants.WIDTH_IS_NULL,
                ValidationConstants.WIDTH_IS_NOT_AN_INTEGER,
                ValidationConstants.WIDTH_OUTSIDE_RANGE,
                bindingResult);
    }

    private void validateHeight(PersonImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateHeight");
        validateTypes.validateIntegerRange(imageCommand.getHeight(),
                ApplicationConstants.MINIMUM_IMAGE_HEIGHT,
                ApplicationConstants.MAXIMUM_IMAGE_HEIGHT,
                "height",
                ValidationConstants.HEIGHT_IS_NULL,
                ValidationConstants.HEIGHT_IS_NOT_AN_INTEGER,
                ValidationConstants.HEIGHT_OUTSIDE_RANGE,
                bindingResult);

    }


    private void validateOrder(PersonImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateOrder");
        validateTypes.validateNonNegativeInteger(imageCommand.getOrder(), "order",
                ValidationConstants.ORDER_IS_NULL,
                ValidationConstants.ORDER_IS_INVALID,
                ValidationConstants.ORDER_IS_NEGATIVE,
                bindingResult);
    }


    private void validateLevel(String integerString, BindingResult bindingResult) {
        logger.debug("AppendixImageCommandValidator::validateLevel");
        validateTypes.validateIntegerStaredRange(integerString,
                ApplicationConstants.LATEX_BOOK,
                ApplicationConstants.LATEX_SUB_PARAGRAPH, "level",
                ValidationConstants.LEVEL_IS_NULL,
                ValidationConstants.LEVEL_IS_INVALID,
                ValidationConstants.LEVEL_IS_OUTSIDE_LIMITS,
                bindingResult);
    }

    private void validatePerson(PersonImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateName");
        validateTypes.validatePerson(imageCommand.getPerson(), "person", ValidationConstants.PERSON_IS_NULL, bindingResult);
    }

    private void validateImage(PersonImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateImage");
        validateTypes.validateImage(imageCommand.getImage(), "image", ValidationConstants.IMAGE_IS_NULL, bindingResult);
    }




}

