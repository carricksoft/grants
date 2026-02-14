/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;


@SuppressWarnings("unused")
@Component
public class PlaceTextCommandValidatorImpl implements PlaceTextCommandValidator{

    private static final Logger logger = LogManager.getLogger(PlaceTextCommandValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public PlaceTextCommandValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(PlaceTextCommand placeTextCommand, BindingResult bindingResult) {
        logger.debug("PlaceTextCommandValidator::validate");
        validatePlace(placeTextCommand.getPlace(), bindingResult);
        validateOrder(placeTextCommand.getOrder(), bindingResult);
        validateLevel(placeTextCommand.getLevel(), bindingResult);
    }

    private void validateLevel(String integerString, BindingResult bindingResult) {
        logger.debug("AppendixImageCommandValidator::validateLevel");
        validateTypes.validateIntegerAsteriskRange(integerString,
                ApplicationConstants.LATEX_BOOK,
                ApplicationConstants.LATEX_SUB_PARAGRAPH, "level",
                ValidationConstants.LEVEL_IS_NULL,
                ValidationConstants.LEVEL_IS_INVALID,
                ValidationConstants.LEVEL_IS_OUTSIDE_LIMITS,
                bindingResult);
    }


    private void validatePlace(Place place, BindingResult bindingResult) {
        logger.debug("PlaceTextCommandValidator::validatePlace");
        validateTypes.validatePlace(place, "place", ValidationConstants.PLACE_IS_NULL, bindingResult);
    }

    private void validateOrder(String order, BindingResult bindingResult) {
        logger.debug("PlaceTextCommandValidator::validateOrder");
        validateTypes.validateNonNegativeInteger(order, "order",ValidationConstants.ORDER_IS_NULL,
                ValidationConstants.ORDER_IS_INVALID, ValidationConstants.ORDER_IS_NEGATIVE,bindingResult);
    }

}

