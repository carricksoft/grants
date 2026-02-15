/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.appendixText;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;

@Component
public class CapitaliseAppendixTextCommandImpl implements CapitaliseAppendixTextCommand {

    private static final Logger logger = LogManager.getLogger(CapitaliseAppendixTextCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseAppendixTextCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(AppendixTextCommand appendixTextCommand) {
        logger.debug("CapitaliseAppendixText::capitalise");
        appendixTextCommand.setHeading(capitaliseString.capitalise(appendixTextCommand.getHeading()));
    }

}
