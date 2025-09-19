/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.text;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class AppendixTextCommandTest {

    private AppendixTextCommand appendixTextCommand;

    @BeforeEach
    void setUp() {
        appendixTextCommand = new AppendixTextCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(appendixTextCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        appendixTextCommand.setId(id);
        assertEquals(id, appendixTextCommand.getId());
    }

    @Test
    void getLevelTest() {
        assertNull(appendixTextCommand.getLevel());
    }

    @Test
    void setLevelTest() {
        String level = GetRandomString();
        appendixTextCommand.setLevel(level);
        assertEquals(level, appendixTextCommand.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(appendixTextCommand.getOrder());
    }

    @Test
    void setOrderTest() {
        String order = GetRandomString();
        appendixTextCommand.setOrder(order);
        assertEquals(order, appendixTextCommand.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(appendixTextCommand.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        appendixTextCommand.setHeading(heading);
        assertEquals(heading, appendixTextCommand.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(appendixTextCommand.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        appendixTextCommand.setContent(content);
        assertEquals(content, appendixTextCommand.getContent());
    }

}