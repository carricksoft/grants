/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.documentimage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;


@Component
public class CapitaliseDocumentImageCommandImpl implements CapitaliseDocumentImageCommand {

    private static final Logger logger = LogManager.getLogger(CapitaliseDocumentImageCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseDocumentImageCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(DocumentImageCommand documentImageCommand) {
        logger.debug("CapitaliseDocumentImage::capitalise");
        documentImageCommand.setCaption(capitaliseString.capitalise(documentImageCommand.getCaption()));
    }

}
