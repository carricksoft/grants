/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.text.persontext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;

@Component
public class CapitalisePersonTextCommandImpl implements CapitalisePersonTextCommand {

    private static final Logger logger = LogManager.getLogger(CapitalisePersonTextCommandImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitalisePersonTextCommandImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(PersonTextCommand personTextCommand) {
        logger.debug("CapitalisePersonText::capitalise");
        personTextCommand.setHeading(capitaliseString.capitalise(personTextCommand.getHeading()));
    }

}
