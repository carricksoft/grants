/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


public class BaseEntityTest {

    BaseEntity baseEntity;

    @BeforeEach
    void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    void getIdTest() {
        assertNull(baseEntity.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId());
    }
}