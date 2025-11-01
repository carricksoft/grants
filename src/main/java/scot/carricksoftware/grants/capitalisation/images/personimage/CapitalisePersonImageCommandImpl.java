/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.personimage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;

@Component
public class CapitalisePersonImageCommandImpl implements CapitalisePersonImageCommand {

    private static final Logger logger = LogManager.getLogger(CapitalisePersonImageCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitalisePersonImageCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(PersonImageCommand personImageCommand) {
        logger.debug("CapitalisePersonImage::capitalise");
        personImageCommand.setCaption(capitaliseString.capitalise(personImageCommand.getCaption()));
    }

}
