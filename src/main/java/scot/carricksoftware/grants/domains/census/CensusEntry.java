/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.people.Person;


@Entity
public class CensusEntry extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "census_id")
    Census census;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    String otherPerson;

    @SuppressWarnings("unused")
    public Census getCensus() {
        return census;
    }

    @SuppressWarnings("unused")
    public void setCensus(Census census) {
        this.census = census;
    }

    @SuppressWarnings("unused")
    public Person getPerson() {
        return person;
    }

    @SuppressWarnings("unused")
    public void setPerson(Person person) {
        this.person = person;
    }

    @SuppressWarnings("unused")
    public String getOtherPerson() {
        return otherPerson;
    }

    @SuppressWarnings("unused")
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
