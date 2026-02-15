/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.placetext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.text.PlaceTextCommand;

@Component
public class CapitalisePlaceTextCommandImpl implements CapitalisePlaceTextCommand {

    private static final Logger logger = LogManager.getLogger(CapitalisePlaceTextCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitalisePlaceTextCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(PlaceTextCommand placeTextCommand) {
        logger.debug("CapitalisePlaceText::capitalise");
        placeTextCommand.setHeading(capitaliseString.capitalise(placeTextCommand.getHeading()));
    }

}
