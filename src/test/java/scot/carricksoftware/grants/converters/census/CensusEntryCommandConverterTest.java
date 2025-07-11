/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:22. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.census.CensusEntryCommand;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.*;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.general.YesNo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCensusEntryRandomEnums.*;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateGeneralRandomEnums.GetRandomGeneralYesNo;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class CensusEntryCommandConverterTest {

    private CensusEntryCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new CensusEntryCommandConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String name = GetRandomString();
        CensusEntryRelationship relationship = GetRandomCensusEntryRelationship();
        CensusEntryCondition condition = GetRandomCensusEntryCondition();
        CensusEntryGaelic gaelic = GetRandomCensusEntryGaelic();
        CensusEntryWorker worker = GetRandomCensusEntryWorker();
        CensusEntryCommand source = new CensusEntryCommandImpl();
        Census census = GetRandomCensus();
        Person person = GetRandomPerson();
        String age = GetRandomString();
        String whereBorn = GetRandomString();
        Sex sex = GetRandomCensusEntrySex();
        String birthYear = GetRandomString();
        String birthDay = GetRandomString();
        String personalOccupation = GetRandomString();
        String notes = GetRandomString();
        String childrenBornAlive = GetRandomString();
        String childrenWhoHaveDied = GetRandomString();
        String yearsCompletedMarriage = GetRandomString();
        String childrenStillAlive = GetRandomString();
        String industryOrService = GetRandomString();
        YesNo workingAtHome = GetRandomGeneralYesNo();


        source.setId(id);
        source.setName(name);
        source.setCensus(census);
        source.setPerson(person);
        source.setRelationship(relationship);
        source.setCondition(condition);
        source.setGaelic(gaelic);
        source.setWorker(worker);
        source.setAge(age);
        source.setWhereBorn(whereBorn);
        source.setSex(sex);
        source.setBirthYear(birthYear);
        source.setBirthDay(birthDay);
        source.setPersonalOccupation(personalOccupation);
        source.setNotes(notes);
        source.setChildrenBornAlive(childrenBornAlive);
        source.setChildrenWhoHaveDied(childrenWhoHaveDied);
        source.setYearsCompletedMarriage(yearsCompletedMarriage);
        source.setChildrenStillAlive(childrenStillAlive);
        source.setIndustryOrService(industryOrService);
        source.setWorkingAtHome(workingAtHome);


        CensusEntry target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(name, target.getName());
        assertEquals(census, target.getCensus());
        assertEquals(person, target.getPerson());
        assertEquals(relationship, target.getRelationship());
        assertEquals(condition, target.getCondition());
        assertEquals(gaelic, target.getGaelic());
        assertEquals(worker, target.getWorker());
        assertEquals(age, target.getAge());
        assertEquals(whereBorn, target.getWhereBorn());
        assertEquals(sex, target.getSex());
        assertEquals(birthYear, target.getBirthYear());
        assertEquals(birthDay, target.getBirthDay());
        assertEquals(personalOccupation, target.getPersonalOccupation());
        assertEquals(notes, target.getNotes());
        assertEquals(childrenBornAlive, target.getChildrenBornAlive());
        assertEquals(childrenStillAlive, target.getChildrenStillAlive());
        assertEquals(yearsCompletedMarriage, target.getYearsCompletedMarriage());
        assertEquals(childrenWhoHaveDied, target.getChildrenWhoHaveDied());
        assertEquals(workingAtHome, target.getWorkingAtHome());
        assertEquals(industryOrService, target.getIndustryOrService());
    }
}