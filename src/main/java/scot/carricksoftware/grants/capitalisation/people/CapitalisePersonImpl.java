/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.people.PersonCommand;

@Component
public class CapitalisePersonImpl implements CapitalisePerson {

    private static final Logger logger = LogManager.getLogger(CapitalisePersonImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitalisePersonImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(PersonCommand personCommand) {
        logger.debug("CapitalisePersonImpl::capitalise");
        personCommand.setFirstName(capitaliseString.capitalise(personCommand.getFirstName()));
        personCommand.setLastName(capitaliseString.capitalise(personCommand.getLastName()));
    }



}
