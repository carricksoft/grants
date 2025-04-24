/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class UpdateRecordedYearOfBirthImpl implements UpdateRecordedYearOfBirth {

    private static final Logger logger = LogManager.getLogger(UpdateRecordedYearOfBirthImpl.class);

    public UpdateRecordedYearOfBirthImpl(PersonConverter personConverter) {
    }

    @Override
    public void updateRecordedYearOfBirth(CensusEntryCommand censusEntryCommand) {
        logger.info("UpdateRecordedYearOfBirthImpl::updateRecordedYearOfBirth");
        Person person = censusEntryCommand.getPerson();
        if (person.getRecordedYearOfBirth() == null) {
            String dateString = censusEntryCommand.getCensus().getCensusDate().label;

            String[] dateStrings = dateString.split("/");
            Integer year = Integer.valueOf(dateStrings[2]);
            try {
                Integer age = Integer.valueOf(censusEntryCommand.getAge());
                person.setRecordedYearOfBirth(String.valueOf(year - age));
            } catch (NumberFormatException e) {
                logger.info(" -- Age cannot be parsed");
            }
        }
    }
}
