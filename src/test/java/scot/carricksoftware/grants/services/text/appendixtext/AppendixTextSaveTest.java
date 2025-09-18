/*
 * Copyright (c) Andrew Grant of Carrick Software 27/03/2025, 01:24. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.appendixtext;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.commands.text.AppendixTextCommandImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverterImpl;
import scot.carricksoftware.grants.domains.text.AppendixText;
import scot.carricksoftware.grants.repositories.text.AppendixTextRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomAppendixText;


@ExtendWith(MockitoExtension.class)
public class AppendixTextSaveTest {

    AppendixTextService appendixTextService;

    @Mock
    AppendixTextRepository appendixTextRepositoryMock;

    @Mock
    AppendixTextConverterImpl appendixTextConverterImplMock;

    @Mock
    AppendixTextCommandConverterImpl appendixTextCommandConverterImplMock;


    @BeforeEach
    public void setUp() {
        appendixTextService = new AppendixTextServiceImpl(appendixTextRepositoryMock,
                appendixTextConverterImplMock,
                appendixTextCommandConverterImplMock);
    }

    @SuppressWarnings("unused")
    @Mock
    Pageable pageableMock;


    @Test
    public void saveTest() {
        AppendixText appendixText = new AppendixText();

        when(appendixTextRepositoryMock.save(appendixText)).thenReturn(appendixText);

        assertEquals(appendixText, appendixTextService.save(appendixText));
    }

    @Test
    public void saveAppendixTextCommandTest() {
        AppendixText appendixText = GetRandomAppendixText();
        AppendixTextCommand appendixTextCommand = new AppendixTextCommandImpl();
        when(appendixTextCommandConverterImplMock.convert(appendixTextCommand)).thenReturn(appendixText);
        when(appendixTextRepositoryMock.save(appendixText)).thenReturn(appendixText);
        when(appendixTextConverterImplMock.convert((appendixText))).thenReturn(appendixTextCommand);

        assertEquals(appendixTextCommand, appendixTextService.saveAppendixTextCommand(appendixTextCommand));
    }


}