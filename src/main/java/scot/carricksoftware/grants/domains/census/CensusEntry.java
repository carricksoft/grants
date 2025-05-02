/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.*;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.*;

@Entity
public class CensusEntry extends BaseEntity {

    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`census_id`")
    private Census census;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`person_id`")
    private Person person;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`relationship`")
    private CensusEntryRelationship relationship;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`gaelic`")
    private CensusEntryGaelic gaelic;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`condition`")
    private CensusEntryCondition condition;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`worker`")
    private CensusEntryWorker worker;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`sex`")
    private CensusEntrySex sex;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`age`")
    private String age;


    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`where_born`")
    private String whereBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`birth_day`")
    private String birthDay;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`birth_year`")
    private String birthYear;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`personal_occupation`")
    private String personalOccupation;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`notes`")
    private String notes;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Census getCensus() {
        return census;
    }

    public void setCensus(Census census) {
        this.census = census;
    }

    public String toString() {
        return census.toString();
    }

    public CensusEntryRelationship getRelationship() {
        return relationship;
    }

    public void setRelationship(CensusEntryRelationship relationship) {
        this.relationship = relationship;
    }

    public CensusEntryCondition getCondition() {
        return this.condition;
    }

    public void setCondition(CensusEntryCondition condition) {
        this.condition = condition;
    }

    public CensusEntryGaelic getGaelic() {
        return this.gaelic;
    }

    public void setGaelic(CensusEntryGaelic gaelic) {
        this.gaelic = gaelic;
    }

    public CensusEntryWorker getWorker() {
        return this.worker;
    }

    public void setWorker(CensusEntryWorker worker) {
        this.worker = worker;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWhereBorn() {
        return this.whereBorn;
    }

    public void setWhereBorn(String whereBorn) {
        this.whereBorn = whereBorn;
    }

    public CensusEntrySex getSex() {
        return this.sex;
    }

    public void setSex(CensusEntrySex sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getPersonalOccupation() {
        return this.personalOccupation;
    }

    public void setPersonalOccupation(String occupation) {
        this.personalOccupation = occupation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
