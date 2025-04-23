/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.censusentry;

import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.people.Person;

public interface UpdateYearsOfBirth {
     @SuppressWarnings({"EmptyMethod", "unused"})
     void updateRecordedYearOfBirth(@SuppressWarnings("unused") CensusEntryCommand censusEntryCommand, @SuppressWarnings("unused") Person person);
}
