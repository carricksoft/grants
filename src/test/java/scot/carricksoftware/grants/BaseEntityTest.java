/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseEntityTest {

    BaseEntity baseEntity;

    @Before
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void getIdTest() {
        assertNull(baseEntity.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        baseEntity.setId(id);
        assertEquals(id, baseEntity.getId());
    }
}