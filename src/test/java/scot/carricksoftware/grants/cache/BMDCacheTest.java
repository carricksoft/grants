/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BMDCacheTest {

    private BMDCache cache;

    @BeforeEach
    void setUp() {
        cache = new BMDCacheImpl();
    }

    @Test
    void constructorTest() {
        assertNotNull(cache);
    }
}