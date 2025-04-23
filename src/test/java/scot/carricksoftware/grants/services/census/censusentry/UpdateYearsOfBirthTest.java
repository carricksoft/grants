/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.census.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateYearsOfBirthTest {

    private UpdateYearsOfBirth updateYearsOfBirth;

    @BeforeEach
    void setUp() {
        updateYearsOfBirth = new UpdateYearsOfBirthImpl();
    }

    @Test
    public void existsTest() {
       assertNotNull(updateYearsOfBirth);
    }
}