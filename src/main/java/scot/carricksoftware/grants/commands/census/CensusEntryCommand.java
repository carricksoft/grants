/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.census;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class CensusEntryCommand {

    Long id;
    Census census;
    Person person;
    String otherPerson;

    public CensusEntryCommand() {
        // required by JPA
    }

    @SuppressWarnings("unused")
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(Long id) {
        this.id = id;
    }

    public Census getCensus() {
        return census;
    }

    public void setCensus(Census census) {
        this.census = census;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getOtherPerson() {
        return otherPerson;
    }

    public void setOtherPerson(String otherPerson) {
        this.otherPerson = otherPerson;
    }

    @Override
    public String toString() {
        return census.toString() +
                ", (" + person.toString() +
                "), (" + otherPerson +")";
    }
}
