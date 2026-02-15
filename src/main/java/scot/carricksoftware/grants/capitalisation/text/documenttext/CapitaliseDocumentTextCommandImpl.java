/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.documenttext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;

@Component
public class CapitaliseDocumentTextCommandImpl implements CapitaliseDocumentTextCommand {

    private static final Logger logger = LogManager.getLogger(CapitaliseDocumentTextCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseDocumentTextCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(DocumentTextCommand documentTextCommand) {
        logger.debug("CapitaliseDocumentText::capitalise");
        documentTextCommand.setHeading(capitaliseString.capitalise(documentTextCommand.getHeading()));
    }

}
