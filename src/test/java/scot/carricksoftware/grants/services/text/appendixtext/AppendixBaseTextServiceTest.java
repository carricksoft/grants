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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverterImpl;
import scot.carricksoftware.grants.domains.text.AppendixText;
import scot.carricksoftware.grants.repositories.text.AppendixTextRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomAppendixText;


@ExtendWith(MockitoExtension.class)
public class AppendixBaseTextServiceTest {

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

    @Mock
    Page<AppendixText> pageMock;

    @Test
    public void deleteByIdTest() {
        Long id = GetRandomLong();
        appendixTextService.deleteById(id);
        verify(appendixTextRepositoryMock).deleteById(id);
    }

    @Test
    public void CountTest() {
        long result = GetRandomLong();
        when(appendixTextRepositoryMock.count()).thenReturn(result);
        assertEquals(result, appendixTextService.count());
    }

    @Test
    public void getPagedCountriesTest() {
        List<AppendixText> result = new ArrayList<>();
        AppendixText appendixText = GetRandomAppendixText();
        result.add(appendixText);
        when(pageMock.getContent()).thenReturn(result);
        when(appendixTextRepositoryMock.findAll(any(Pageable.class))).thenReturn(pageMock);
        assertEquals(result, appendixTextService.getPagedAppendixTexts(0));
    }


}