/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 10:44. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.documenttext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;

import scot.carricksoftware.grants.domains.text.DocumentText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DocumentTextConverterTest {

    private DocumentTextConverter converter;

    @BeforeEach
    void setUp() {
        converter = new DocumentTextConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        String order = GetRandomString();
        String level = GetRandomString();
        String heading = GetRandomString();
        String content = GetRandomString();
        DocumentText source = new DocumentText();

        source.setId(Id);
        source.setOrder(order);
        source.setLevel(level);
        source.setHeading(heading);
        source.setOrder(order);
        source.setContent(content);

        DocumentTextCommand target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(order, target.getOrder());
        assertEquals(level, target.getLevel());
        assertEquals(heading, target.getHeading());
        assertEquals(content, target.getContent());
    }
}