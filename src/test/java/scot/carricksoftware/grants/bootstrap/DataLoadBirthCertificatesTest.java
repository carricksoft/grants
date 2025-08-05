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
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.certificates.birthcertificates.BirthCertificateService;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class DataLoadBirthCertificatesTest {

    @Mock
    private PersonService personServiceMock;

    @Mock
    private BirthCertificateService birthCertificateServiceMock;
    private Person person;
    private ArgumentCaptor<BirthCertificateCommand> captor;

    @BeforeEach
    void setUp() {
        DataLoadBirthCertificates dataLoadBirthCertificates = new DataLoadBirthCertificates(birthCertificateServiceMock, personServiceMock);
        person = GetRandomPerson();
        captor = ArgumentCaptor.forClass(BirthCertificateCommand.class);
        when(personServiceMock.findById(anyLong())).thenReturn(person);
        dataLoadBirthCertificates.load();
    }

    @Test
    void newBornTest() {
        verify(birthCertificateServiceMock).saveBirthCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getNewBorn());
    }

    @Test
    void motherTest() {
        verify(birthCertificateServiceMock).saveBirthCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getMother());
    }

    @Test
    void fatherTest() {
        verify(birthCertificateServiceMock).saveBirthCertificateCommand(captor.capture());
        assertEquals(person, captor.getValue().getFather());
    }
}