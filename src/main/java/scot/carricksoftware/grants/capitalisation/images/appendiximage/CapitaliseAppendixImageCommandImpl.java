/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.appendiximage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;


@Component
public class CapitaliseAppendixImageCommandImpl implements CapitaliseAppendixImageCommand {

    private static final Logger logger = LogManager.getLogger(CapitaliseAppendixImageCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseAppendixImageCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(AppendixImageCommand appendixImageCommand) {
        logger.debug("CapitaliseAppendixImage::capitalise");
        appendixImageCommand.setCaption(capitaliseString.capitalise(appendixImageCommand.getCaption()));
    }

}
