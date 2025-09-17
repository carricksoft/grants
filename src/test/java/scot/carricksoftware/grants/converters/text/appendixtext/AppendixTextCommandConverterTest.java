/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.appendixtext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.commands.text.AppendixTextCommandImpl;
import scot.carricksoftware.grants.domains.text.AppendixText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class AppendixTextCommandConverterTest {

    private AppendixTextCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new AppendixTextCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Long order = GetRandomLong();
        Long level = GetRandomLong();
        String heading = GetRandomString();
        String content = GetRandomString();

        AppendixTextCommand source = new AppendixTextCommandImpl();

        source.setId(Id);
        source.setOrder(order);
        source.setLevel(level);
        source.setHeading(heading);
        source.setOrder(order);
        source.setContent(content);

        AppendixText target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(order, target.getOrder());
        assertEquals(level, target.getLevel());
        assertEquals(heading, target.getHeading());
        assertEquals(content, target.getContent());
    }
}