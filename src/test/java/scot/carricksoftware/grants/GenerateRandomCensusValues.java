/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;

import java.time.LocalDate;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;

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
    public static CensusCommand GetRandomCensusCommand() {
        CensusCommand censusCommand = new CensusCommand();
        censusCommand.setPlace(GetRandomPlace());
        censusCommand.setId(GetRandomLong());
        censusCommand.setDate(LocalDate.now().format(ApplicationConstants.FORMATTER));
        return censusCommand;
    }

}
