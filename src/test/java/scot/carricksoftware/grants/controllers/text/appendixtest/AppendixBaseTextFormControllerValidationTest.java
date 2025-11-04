/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.appendixtest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.controllers.text.appendixtext.AppendixTextFormControllerImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverterImpl;
import scot.carricksoftware.grants.services.text.appendixtext.AppendixTextService;
import scot.carricksoftware.grants.validators.text.AppendixTextCommandValidatorImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AppendixBaseTextFormControllerValidationTest {

    @SuppressWarnings("unused")
    private AppendixTextFormControllerImpl appendixTextController;

    @Mock
    private AppendixTextService appendixTextServiceMock;

    @Mock
    private AppendixTextCommandConverterImpl appendixTextCommandConverterMock;

    @Mock
    private AppendixTextConverterImpl appendixTextConverterMock;


    @Mock
    private AppendixTextCommand appendixTextCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private AppendixTextCommandValidatorImpl appendixTextCommandValidatorImplMock;

    @Mock
    private Model modelMock;


    @BeforeEach
    public void setUp() {
        appendixTextController = new AppendixTextFormControllerImpl(appendixTextServiceMock,
                appendixTextCommandConverterMock,
                appendixTextConverterMock,
                appendixTextCommandValidatorImplMock);
    }


    @Test
    public void saveOrUpdateValidationTest() {
        when(appendixTextServiceMock.saveAppendixTextCommand(any())).thenReturn(appendixTextCommandMock);
        appendixTextController.saveOrUpdate(appendixTextCommandMock, bindingResultMock, modelMock);
        verify(appendixTextCommandValidatorImplMock).validate(appendixTextCommandMock, bindingResultMock);
    }


}