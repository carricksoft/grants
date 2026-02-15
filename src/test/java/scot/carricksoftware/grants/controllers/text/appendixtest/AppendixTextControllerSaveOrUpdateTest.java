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
import scot.carricksoftware.grants.capitalisation.text.appendixText.CapitaliseAppendixTextCommand;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.commands.text.AppendixTextCommandImpl;
import scot.carricksoftware.grants.controllers.text.appendixtext.AppendixTextFormControllerImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverterImpl;
import scot.carricksoftware.grants.services.text.appendixtext.AppendixTextService;
import scot.carricksoftware.grants.validators.text.AppendixTextCommandValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AppendixTextControllerSaveOrUpdateTest {

    @SuppressWarnings("unused")
    private AppendixTextFormControllerImpl appendixTextController;

    @Mock
    private AppendixTextService appendixTextServiceMock;

    @Mock
    private AppendixTextCommandConverterImpl appendixTextCommandConverterMock;

    @Mock
    private AppendixTextConverterImpl appendixTextConverterMock;

    @Mock
    private Model modelMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private AppendixTextCommandValidatorImpl appendixTextCommandValidatorImplMock;

    @Mock
    private CapitaliseAppendixTextCommand capitaliseAppendixTextCommandMock;


    private AppendixTextCommand appendixTextCommand;


    @BeforeEach
    public void setUp() {
        appendixTextController = new AppendixTextFormControllerImpl(appendixTextServiceMock,
                appendixTextCommandConverterMock,
                appendixTextConverterMock,
                appendixTextCommandValidatorImplMock,
                capitaliseAppendixTextCommandMock);
        appendixTextCommand = new AppendixTextCommandImpl();
    }

    @Test
    public void saveOrUpdateNoErrorsTest() {
        Long id = 4L;
        appendixTextCommand.setId(id);
        when(appendixTextServiceMock.saveAppendixTextCommand(any(AppendixTextCommand.class))).thenReturn(appendixTextCommand);
        assertEquals("redirect:/appendixText/4/show", appendixTextController.saveOrUpdate(appendixTextCommand, bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateErrorsTest() {
        Long id = 4L;
        appendixTextCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("text/appendixText/form", appendixTextController.saveOrUpdate(appendixTextCommand, bindingResultMock, modelMock));
    }

}