/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates.divorce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class DivorceCertificateCommandIDTest {

    private DivorceCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new DivorceCertificateCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

}