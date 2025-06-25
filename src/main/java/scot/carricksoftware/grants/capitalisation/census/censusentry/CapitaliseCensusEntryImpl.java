/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.census.censusentry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;

@Component
public class CapitaliseCensusEntryImpl implements CapitaliseCensusEntry {

    private static final Logger logger = LogManager.getLogger(CapitaliseCensusEntryImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseCensusEntryImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(CensusEntryCommand censusEntryCommand) {
        logger.debug("CapitaliseCensusEntryImpl::capitalise");
        censusEntryCommand.setWhereBorn(capitaliseString.capitalise(censusEntryCommand.getWhereBorn()));
        censusEntryCommand.setPersonalOccupation(capitaliseString.capitalise(censusEntryCommand.getPersonalOccupation()));
        censusEntryCommand.setNotes(capitaliseString.capitalise(censusEntryCommand.getNotes()));
        censusEntryCommand.setName(capitaliseString.capitalise(censusEntryCommand.getName()));
        censusEntryCommand.setIndustryOrService(capitaliseString.capitalise(censusEntryCommand.getIndustryOrService()));
    }


}
