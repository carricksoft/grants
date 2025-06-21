/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CapitaliseBirthCertificateCommandTest {

    @Mock
    private CapitaliseString capitaliseStringMock;

    @Mock
    private BirthCertificateCommand birthCertificateCommandMock;

    @SuppressWarnings("unused")
    private Capitalise capitalise;

    @BeforeEach
    void setUp() {
        capitalise = new CapitaliseImpl(capitaliseStringMock);
    }

    @Test
    void birthCertificateCommandTest() {
        when(birthCertificateCommandMock.getInformantQualification()).thenReturn("A");
        when(birthCertificateCommandMock.getUntrackedWhereBorn()).thenReturn("B");
        when(birthCertificateCommandMock.getUntrackedFather()).thenReturn("C");
        when(birthCertificateCommandMock.getUntrackedInformant()).thenReturn("D");
        when(birthCertificateCommandMock.getWhenBorn()).thenReturn("E");
        when(birthCertificateCommandMock.getCertificateNumber()).thenReturn("F");

        capitalise.capitalise(birthCertificateCommandMock);
        InOrder inOrder = inOrder(capitaliseStringMock);

        inOrder.verify(capitaliseStringMock).capitalise(birthCertificateCommandMock.getInformantQualification());
        inOrder.verify(capitaliseStringMock ).capitalise(birthCertificateCommandMock.getUntrackedWhereBorn());
        verify(capitaliseStringMock).capitalise(birthCertificateCommandMock.getUntrackedFather());
        verify(capitaliseStringMock).capitalise(birthCertificateCommandMock.getUntrackedInformant());
        verify(capitaliseStringMock).capitalise(birthCertificateCommandMock.getWhenBorn());
        verify(capitaliseStringMock).capitalise(birthCertificateCommandMock.getCertificateNumber());
    }
}