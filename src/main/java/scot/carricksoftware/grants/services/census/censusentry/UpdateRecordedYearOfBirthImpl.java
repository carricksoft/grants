/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static java.util.Objects.isNull;

@Component
public class UpdateRecordedYearOfBirthImpl implements UpdateRecordedYearOfBirth {

    private static final Logger logger = LogManager.getLogger(UpdateRecordedYearOfBirthImpl.class);
    private final PersonService personService;
    private final PersonConverter personConverter;

    public UpdateRecordedYearOfBirthImpl(PersonConverter personConverter,
                                         PersonService personService) {
        this.personService = personService;
        this.personConverter = personConverter;
    }

    @Override
    public void updateRecordedYearOfBirth(CensusEntryCommand censusEntryCommand) {
        logger.debug("UpdateRecordedYearOfBirthImpl::updateRecordedYearOfBirth");
        Person person = censusEntryCommand.getPerson();
        if (!isNull(person)) {
            if (isNull(censusEntryCommand.getBirthYear()) || censusEntryCommand.getBirthYear().isEmpty()) {
                String dateString = censusEntryCommand.getCensus().getCensusDate().label;
                String[] dateStrings = dateString.split("/");
                Integer year = Integer.valueOf(dateStrings[2]);
                try {
                    Integer age = Integer.valueOf(censusEntryCommand.getAge());
                    updateDate(person, String.valueOf(year - age));
                } catch (NumberFormatException e) {
                    logger.info(" -- Age cannot be parsed");
                }
            } else {
                PersonCommand personCommand = personConverter.convert(person);
                assert personCommand != null;
                personCommand.setRecordedYearOfBirth(censusEntryCommand.getBirthYear());
                personService.savePersonCommand(personCommand);
            }
        }
    }

    private void updateDate(Person person,
                            String dateString) {
        logger.debug("UpdateRecordedYearOfBirthImpl::Date");
        PersonCommand personCommand = personConverter.convert(person);
        if (personCommand != null) {
            personCommand.setRecordedYearOfBirth(dateString);
            personService.savePersonCommand(personCommand);
        } else {
            logNoCommandError();
        }
    }

    private void logNoCommandError() {
        throw new NullPointerException("Person Command is null.");
    }


}
