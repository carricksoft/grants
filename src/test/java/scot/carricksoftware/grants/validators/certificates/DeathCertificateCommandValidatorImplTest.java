/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 11:37. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.certificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.validators.certificates.deathcertificate.DeathCertificateCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

@ExtendWith(MockitoExtension.class)
class DeathCertificateCommandValidatorImplTest {

    private DeathCertificateCommandValidatorImpl commandValidator;

    private ArgumentCaptor<String> stringArgumentCaptor;
    private ArgumentCaptor<String> stringArgumentCaptor2;
    private ArgumentCaptor<String> stringArgumentCaptor3;
    private ArgumentCaptor<Object[]> objectArgumentCaptor;

    private DeathCertificateCommand deathCertificateCommand;

    @Mock
    BindingResult bindingResultMock;

    @BeforeEach
    void setUp() {
        commandValidator = new DeathCertificateCommandValidatorImpl();
        stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor2 = ArgumentCaptor.forClass(String.class);
        stringArgumentCaptor3 = ArgumentCaptor.forClass(String.class);
        objectArgumentCaptor = ArgumentCaptor.forClass(Object[].class);

        deathCertificateCommand = new DeathCertificateCommandImpl();
    }

    @Test
    public void nullPersonTest() {

        commandValidator.validate(deathCertificateCommand, bindingResultMock);

        verify(bindingResultMock).rejectValue(stringArgumentCaptor.capture(),
                stringArgumentCaptor2.capture(),
                objectArgumentCaptor.capture(),
                stringArgumentCaptor3.capture());

        assertEquals("deceased", stringArgumentCaptor.getValue());
        assertEquals("The person cannot be null.", stringArgumentCaptor3.getValue());

    }

    @Test
    public void notNullPersonTest() {
        deathCertificateCommand.setDeceased(GetRandomPerson());
        commandValidator.validate(deathCertificateCommand, bindingResultMock);

        verifyNoInteractions(bindingResultMock);

    }


}