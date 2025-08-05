/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.certificates.deathcertificates.DeathCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class DataLoadDeathCertificatesTest {

    @Mock
    private PersonService personServiceMock;

    @Mock
    private DeathCertificateService deathCertificateServiceMock;

    private Person person;
    private ArgumentCaptor<DeathCertificateCommand> captor;


    @BeforeEach
    void setUp() {
        DataLoadDeathCertificates dataLoadDeathCertificates = new DataLoadDeathCertificates(personServiceMock, deathCertificateServiceMock);
        person = GetRandomPerson();
        captor = ArgumentCaptor.forClass(DeathCertificateCommand.class);
        when(personServiceMock.findById(anyLong())).thenReturn(person);
        dataLoadDeathCertificates.load();
    }

    @Test
    void groomDeceased() {
        verify(deathCertificateServiceMock).saveDeathCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getDeceased());
    }

    @Test
    void fatherTest() {
        verify(deathCertificateServiceMock).saveDeathCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getFather());
    }
}