/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:18. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.domains.census.CensusEntry;

@Component
public class CensusEntryCommandConverterImpl implements CensusEntryCommandConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public CensusEntry convert(CensusEntryCommand source) {
        CensusEntry result = new CensusEntry();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setCensus(source.getCensus());
        result.setPerson(source.getPerson());
        result.setRelationship(source.getRelationship());
        result.setCondition(source.getCondition());
        result.setGaelic(source.getGaelic());
        result.setWorker(source.getWorker());
        result.setAge(source.getAge());
        result.setWhereBorn(source.getWhereBorn());
        result.setSex(source.getSex());
        result.setBirthYear(source.getBirthYear());
        result.setBirthDay(source.getBirthDay());
        result.setPersonalOccupation(source.getPersonalOccupation());
        result.setNotes(source.getNotes());
        return result;
    }


}
