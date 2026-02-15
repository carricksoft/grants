/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.placeimage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.PlaceImageCommand;

@Component
public class CapitalisePlaceImageCommandImpl implements CapitalisePlaceImageCommand {

    private static final Logger logger = LogManager.getLogger(CapitalisePlaceImageCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitalisePlaceImageCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(PlaceImageCommand placeImageCommand) {
        logger.debug("CapitalisePlaceImage::capitalise");
        placeImageCommand.setCaption(capitaliseString.capitalise(placeImageCommand.getCaption()));
    }

}
