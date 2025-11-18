/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DocumentTextCommandTest {

    private DocumentTextCommand documentTextCommand;

    @BeforeEach
    void setUp() {
        documentTextCommand = new DocumentTextCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(documentTextCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        documentTextCommand.setId(id);
        assertEquals(id, documentTextCommand.getId());
    }

    @Test
    void getLevelTest() {
        assertNull(documentTextCommand.getLevel());
    }

    @Test
    void setLevelTest() {
        String level = GetRandomString();
        documentTextCommand.setLevel(level);
        assertEquals(level, documentTextCommand.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(documentTextCommand.getOrder());
    }

    @Test
    void setOrderTest() {
        String order = GetRandomString();
        documentTextCommand.setOrder(order);
        assertEquals(order, documentTextCommand.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(documentTextCommand.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        documentTextCommand.setHeading(heading);
        assertEquals(heading, documentTextCommand.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(documentTextCommand.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        documentTextCommand.setContent(content);
        assertEquals(content, documentTextCommand.getContent());
    }


}