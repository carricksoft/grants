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
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.certificates.marriagecertificates.MarriageCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class DataLoadMarriageCertificatesTest {

    @Mock
    private PersonService personServiceMock;

    @Mock
    private MarriageCertificateService marriageCertificateServiceMock;

    private Person person;
    private ArgumentCaptor<MarriageCertificateCommand> captor;


    @BeforeEach
    void setUp() {
        DataLoadMarriageCertificates dataLoadMarriageCertificates = new DataLoadMarriageCertificates(personServiceMock, marriageCertificateServiceMock);
        person = GetRandomPerson();
        captor = ArgumentCaptor.forClass(MarriageCertificateCommand.class);
        when(personServiceMock.findById(anyLong())).thenReturn(person);
        dataLoadMarriageCertificates.load();
    }

    @Test
    void groomTest() {
        verify(marriageCertificateServiceMock).saveMarriageCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getGroom());
    }

    @Test
    void brideTest() {
        verify(marriageCertificateServiceMock).saveMarriageCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getBride());
    }
}