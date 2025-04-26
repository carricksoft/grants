/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:54. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonToStringTest {

    Person person;

    final String firstName = "First";
    final String lastName = "Last";
    final String recordedBirth = "1920";
    final String certifiedBirth = "1930";


    @BeforeEach
    void setUp() {
        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }

    @Test
    public void NoDatesTest() {
        String requiredResult = "Last, First, -";

        assertEquals(requiredResult, person.toString());
    }

    @Test
    public void certifiedBirthOnlyTest() {
        String requiredResult = "Last, First, " + certifiedBirth + " -";
        person.setCertifiedYearOfBirth(certifiedBirth);

        assertEquals(requiredResult, person.toString());
    }


    @Test
    public void recordedBirthOnlyTest() {
        String requiredResult = "Last, First, (" + recordedBirth + ") -";
        person.setRecordedYearOfBirth(recordedBirth);

        assertEquals(requiredResult, person.toString());
    }

    @Test
    public void bothTest() {
        String requiredResult = "Last, First, " + certifiedBirth + " -";
        person.setCertifiedYearOfBirth(certifiedBirth);
        person.setRecordedYearOfBirth(recordedBirth);

        assertEquals(requiredResult, person.toString());
    }


}