/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:13. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.*;

public interface CensusEntryCommand {

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    Census getCensus();

    void setCensus(Census census);

    Person getPerson();

    void setPerson(Person person);

    CensusEntryRelationship getRelationship();

    void setRelationship(CensusEntryRelationship relationship);

    CensusEntryCondition getCondition();

    void setCondition(CensusEntryCondition condition);

    CensusEntryGaelic getGaelic();

    void setGaelic(CensusEntryGaelic gaelic);

    CensusEntryWorker getWorker();

    void setWorker(CensusEntryWorker worker);

    String getAge();

    void setAge(String age);

    String getWhereBorn();

    void setWhereBorn(String whereBorn);

    CensusEntrySex getSex();

    void setSex(CensusEntrySex sex);

    String getBirthDay();

    void setBirthDay(String birthDay);

    String getBirthYear();

    void setBirthYear(String birthYear);

    String getPersonalOccupation();

    void setPersonalOccupation(String personalOccupation);

    String getNotes();

    void setNotes(String notes);
}
