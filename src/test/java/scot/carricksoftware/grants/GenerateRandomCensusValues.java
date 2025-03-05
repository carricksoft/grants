/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.time.LocalDate;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SuppressWarnings("unused")
@Component
public class GenerateRandomCensusValues {

    @SuppressWarnings("unused")
    public static Census GetRandomCensus() {
        Census census = new Census();
        census.setPlace(GetRandomPlace());
        census.setId(GetRandomLong());
        census.setDate(LocalDate.now().format(ApplicationConstants.FORMATTER));
        return census;
    }

    @SuppressWarnings("unused")
    public static CensusCommandImpl GetRandomCensusCommand() {
        CensusCommandImpl censusCommandImpl = new CensusCommandImpl();
        censusCommandImpl.setPlace(GetRandomPlace());
        censusCommandImpl.setId(GetRandomLong());
        censusCommandImpl.setDate(LocalDate.now().format(ApplicationConstants.FORMATTER));
        return censusCommandImpl;
    }

    public static CensusEntry GetRandomCensusEntry() {
        CensusEntry censusEntry = new CensusEntry();
        censusEntry.setId(GetRandomLong());
        censusEntry.setCensus(GetRandomCensus());
        censusEntry.setPerson(GetRandomPerson());
        censusEntry.setOtherPerson(GetRandomString());
        return censusEntry;
    }

}
