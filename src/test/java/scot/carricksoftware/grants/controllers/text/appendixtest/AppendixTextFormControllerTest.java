/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.appendixtest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.constants.TextAttributeConstants;
import scot.carricksoftware.grants.controllers.text.appendixtext.AppendixTextFormControllerImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverterImpl;
import scot.carricksoftware.grants.domains.text.AppendixText;
import scot.carricksoftware.grants.services.text.appendixtext.AppendixTextService;
import scot.carricksoftware.grants.validators.text.AppendixTextCommandValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomAppendixText;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomAppendixTextCommand;


@ExtendWith(MockitoExtension.class)
public class AppendixTextFormControllerTest {

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
    private AppendixTextCommandValidator appendixTextCommandValidatorMock;

    @BeforeEach
    public void setUp() {
        appendixTextController = new AppendixTextFormControllerImpl(appendixTextServiceMock,
                appendixTextCommandConverterMock,
                appendixTextConverterMock,
                appendixTextCommandValidatorMock);
    }

    @Test
    public void getNewAppendixTextTest() {
        ArgumentCaptor<Object> objectCaptor = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        assertEquals("text/appendixText/form", appendixTextController.getNewAppendixText(modelMock));
        verify(modelMock, atLeast(1)).addAttribute(stringCaptor.capture(), objectCaptor.capture());

        boolean foundAppendixTextCommand = false;


        for (int i = 0; i < stringCaptor.getAllValues().size(); i++) {
            if (stringCaptor.getAllValues().get(i).equals("appendixTextCommand")) {
                if (objectCaptor.getAllValues().get(i).getClass().getSimpleName().equals("AppendixTextCommandImpl")) {
                    foundAppendixTextCommand = true;
                }
            }
        }
        assertTrue(foundAppendixTextCommand);

    }

    @Test
    public void appendixTextEditTestEditTest() {
        Long id = GetRandomLong();
        AppendixText appendixText = GetRandomAppendixText();
        when(appendixTextServiceMock.findById(id)).thenReturn(appendixText);

        assertEquals("text/appendixText/form", appendixTextController.appendixTextEdit(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.APPENDIX_TEXT_COMMAND, appendixText);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        AppendixText appendixText = GetRandomAppendixText();
        AppendixTextCommand appendixTextCommand = GetRandomAppendixTextCommand();

        when(appendixTextServiceMock.findById(id)).thenReturn(appendixText);
        when(appendixTextConverterMock.convert(appendixText)).thenReturn(appendixTextCommand);
        assertEquals("text/appendixText/form", appendixTextController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(TextAttributeConstants.APPENDIX_TEXT_COMMAND, appendixTextCommand);
    }

}