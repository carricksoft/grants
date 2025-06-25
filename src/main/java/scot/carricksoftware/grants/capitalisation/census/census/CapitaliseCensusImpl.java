/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.census.census;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;

@Component
public class CapitaliseCensusImpl implements CapitaliseCensus {
    private static final Logger logger = LogManager.getLogger(CapitaliseCensusImpl.class);

    @Override
    public void capitalise(CensusCommand censusCommand) {
        logger.debug("CapitaliseCensusImpl::capitalise - no action required!");
    }



}
