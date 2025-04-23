/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class UpdateYearsOfBirthImpl implements UpdateYearsOfBirth {

    private static final Logger logger = LogManager.getLogger(UpdateYearsOfBirthImpl.class);

    @Override
    public void updateRecordedYearOfBirth(CensusEntryCommand censusEntryCommand, Person person) {
        logger.debug("updateYearOfBirth::updateRecordedYearOfBirth");
    }
}
