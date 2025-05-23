/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:00. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.*;
import scot.carricksoftware.grants.enums.general.YesNo;

public class CensusEntryCommandImpl implements CensusEntryCommand {

    private Long id;

    private String name;

    private Census census;

    private Person person;

    private CensusEntryRelationship relationship;

    private CensusEntryCondition condition;

    private CensusEntryGaelic gaelic;

    private CensusEntryWorker worker;

    private String age;

    private String whereBorn;

    private CensusEntrySex Sex;

    private String birthDay;

    private String birthYear;

    private String personalOccupation;

    private String notes;

    private String childrenWhoHaveDied;

    private String childrenStillAlive;

    private String childrenBornAlive;

    private String yearsCompletedMarriage;

    private YesNo workingAtHome;

    private String industryOrService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Census getCensus() {
        return census;
    }

    @Override
    public void setCensus(Census census) {
        this.census = census;
    }

    @Override
    public Person getPerson() {
        return this.person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public CensusEntryRelationship getRelationship() {
        return relationship;
    }

    @Override
    public void setRelationship(CensusEntryRelationship relationship) {
        this.relationship = relationship;
    }

    @Override
    public CensusEntryCondition getCondition() {
        return condition;
    }

    @Override
    public void setCondition(CensusEntryCondition condition) {
        this.condition = condition;
    }

    @Override
    public CensusEntryGaelic getGaelic() {
        return gaelic;
    }

    @Override
    public void setGaelic(CensusEntryGaelic gaelic) {
        this.gaelic = gaelic;
    }

    @Override
    public CensusEntryWorker getWorker() {
        return worker;
    }

    @Override
    public void setWorker(CensusEntryWorker worker) {
        this.worker = worker;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getWhereBorn() {
        return whereBorn;
    }

    @Override
    public void setWhereBorn(String whereBorn) {
        this.whereBorn = whereBorn;
    }

    @Override
    public CensusEntrySex getSex() {
        return Sex;
    }

    @Override
    public void setSex(CensusEntrySex sex) {
        Sex = sex;
    }

    @Override
    public String getBirthDay() {
        return birthDay;
    }

    @Override
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthYear() {
        return birthYear;
    }

    @Override
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String getPersonalOccupation() {
        return this.personalOccupation;
    }

    @Override
    public void setPersonalOccupation(String personalOccupation) {
        this.personalOccupation = personalOccupation;
    }

    @Override
    public String getNotes() {
        return notes;
    }

    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String getChildrenWhoHaveDied() {
        return childrenWhoHaveDied;
    }

    @Override
    public void setChildrenWhoHaveDied(String childrenWhoHaveDied) {
        this.childrenWhoHaveDied = childrenWhoHaveDied;
    }

    @Override
    public String getChildrenStillAlive() {
        return childrenStillAlive;
    }

    @Override
    public void setChildrenStillAlive(String childrenStillAlive) {
        this.childrenStillAlive = childrenStillAlive;
    }

    @Override
    public String getChildrenBornAlive() {
        return childrenBornAlive;
    }

    @Override
    public void setChildrenBornAlive(String childrenBornAlive) {
        this.childrenBornAlive = childrenBornAlive;
    }

    @Override
    public String getYearsCompletedMarriage() {
        return yearsCompletedMarriage;
    }

    @Override
    public void setYearsCompletedMarriage(String yearsCompletedMarriage) {
        this.yearsCompletedMarriage = yearsCompletedMarriage;
    }

    @Override
    public YesNo getWorkingAtHome() {
        return workingAtHome;
    }

    @Override
    public void setWorkingAtHome(YesNo workingAtHome) {
        this.workingAtHome = workingAtHome;
    }

    @Override
    public String getIndustryOrService() {
        return industryOrService;
    }

    @Override
    public void setIndustryOrService(String industryOrService) {
        this.industryOrService = industryOrService;
    }
}
