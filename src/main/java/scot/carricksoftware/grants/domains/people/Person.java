/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */


package scot.carricksoftware.grants.domains.people;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.util.Objects;
import java.util.Set;

@Entity
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToMany
    @JoinColumn(name = "person_id")
    private Set<CensusEntry> censusEntries;


    @SuppressWarnings("unused")
    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unused")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @SuppressWarnings("unused")
    public String getLastName() {
        return lastName;
    }

    @SuppressWarnings("unused")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SuppressWarnings("unused")
    public Set<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    @SuppressWarnings("unused")
    public void setCensusEntries(Set<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

}
