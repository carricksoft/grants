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


@SuppressWarnings("unused")
@Component
public class PlaceTextCommandValidatorImpl implements PlaceTextCommandValidator{

    private static final Logger logger = LogManager.getLogger(PlaceTextCommandValidatorImpl.class);

    public void validate(PlaceTextCommand personTextCommand, BindingResult bindingResult) {
      logger.debug("PlaceTextCommandValidator::validate");
    }

}

