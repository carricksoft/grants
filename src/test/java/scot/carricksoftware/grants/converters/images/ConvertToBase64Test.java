/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertToBase64Test {

    private ConvertToBase64 converter;

    @BeforeEach
    void setUp() {
        converter = new ConvertToBase64Impl();
    }

    @Test
    void convertTest() {
        String testString = "Many hands make light work.";

        String wikipediaAnswer = "TWFueSBoYW5kcyBtYWtlIGxpZ2h0IHdvcmsu";

        byte[] testBytes = testString.getBytes();
        assertEquals(wikipediaAnswer, converter.convert(testBytes));
    }

}