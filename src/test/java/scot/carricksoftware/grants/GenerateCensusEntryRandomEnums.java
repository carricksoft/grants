/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.enums.censusentry.*;

import java.util.Random;

@SuppressWarnings("unused")
@Component
public class GenerateCensusEntryRandomEnums {

    public static CensusEntryCondition GetRandomCensusEntryCondition() {

        CensusEntryCondition[] conditions = CensusEntryCondition.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, conditions.length);
        return conditions[randomInt];
    }

    public static CensusEntryGaelic GetRandomCensusEntryGaelic() {
        CensusEntryGaelic[] gaelicArray = CensusEntryGaelic.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, gaelicArray.length);
        return gaelicArray[randomInt];
    }

    public static CensusEntryRelationship GetRandomCensusEntryRelationship() {
        CensusEntryRelationship[] relationships = CensusEntryRelationship.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, relationships.length);
        return relationships[randomInt];
    }

    public static CensusEntryWorker GetRandomCensusEntryWorker() {
        CensusEntryWorker[] workers = CensusEntryWorker.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, workers.length);
        return workers[randomInt];
    }

    public static CensusEntrySex GetRandomCensusEntrySex() {
        CensusEntrySex[] sex = CensusEntrySex.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, sex.length);
        return sex[randomInt];
    }
}
