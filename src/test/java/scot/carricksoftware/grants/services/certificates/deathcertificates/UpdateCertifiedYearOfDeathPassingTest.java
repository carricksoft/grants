/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.deathcertificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateCertifiedYearOfDeathPassingTest {

    private UpdateCertifiedYearOfDeath updateCertifiedYearOfDeath;

    @Mock
    private PersonService personServiceMock;

    @Mock
    private PersonConverter personConverterMock;

    @Mock
    private PersonCommand personCommandMock;

    @Mock
    private DeathCertificateCommand deathCertificateCommandMock;


    @BeforeEach
    void setUp() {
        updateCertifiedYearOfDeath = new UpdateCertifiedYearOfDeathImpl(personConverterMock, personServiceMock);
    }

    @Test()
    void passingTest() {
        when(deathCertificateCommandMock.getDeceased()).thenReturn(new Person());
        when(deathCertificateCommandMock.getWhenDied()).thenReturn("25/01/1953 01:01)");
        when(personConverterMock.convert(any())).thenReturn(personCommandMock);

        updateCertifiedYearOfDeath.updateCertifiedYearOfDeath(deathCertificateCommandMock);

        verify(personCommandMock).setCertifiedYearOfDeath("1953");
        verify(personServiceMock).savePersonCommand(personCommandMock);
    }

}