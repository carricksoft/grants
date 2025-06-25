/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

class BirthCertificateCommandRegisteredTest {

    private BirthCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new BirthCertificateCommandImpl();
    }

    @Test
    void getWhenRegisteredTest() {
        assertNull(command.getWhenRegistered());
    }

    @Test
    void setWhenRegisteredTest() {
        String whenRegistered = GetRandomString();
        command.setWhenRegistered(whenRegistered);
        assertEquals(whenRegistered, command.getWhenRegistered());
    }

    @Test
    void getWhereRegisteredTest() {
        assertNull(command.getWhereRegistered());
    }

    @Test
    void setWhereRegisteredTest() {
        String whereRegistered = GetRandomString();
        command.setWhereRegistered(whereRegistered);
        assertEquals(whereRegistered, command.getWhereRegistered());
    }


}