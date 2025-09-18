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
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverterImpl;
import scot.carricksoftware.grants.domains.text.AppendixText;
import scot.carricksoftware.grants.repositories.text.AppendixTextRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomAppendixText;

@ExtendWith(MockitoExtension.class)
public class AppendixTextFindTest {

    AppendixTextService appendixTextService;

    @Mock
    AppendixTextRepository appendixTextRepositoryMock;

    @Mock
    AppendixTextConverterImpl appendixTextConverterMock;

    @Mock
    AppendixTextCommandConverterImpl appendixTextCommandConverterMock;

    @BeforeEach
    public void setUp() {
        appendixTextService = new AppendixTextServiceImpl(appendixTextRepositoryMock,
                appendixTextConverterMock,
                appendixTextCommandConverterMock);
    }

    @Test
    public void testFindAll() {
        List<AppendixText> countries = new ArrayList<>();
        countries.add(GetRandomAppendixText());
        when(appendixTextRepositoryMock.findAll()).thenReturn(countries);
        assertEquals(countries, appendixTextService.findAll());
    }

    @Test
    public void testFindByFoundId() {
        Long id = GetRandomLong();
        AppendixText appendixText = GetRandomAppendixText();
        Optional<AppendixText> appendixTextOptional = Optional.of(appendixText);
        when(appendixTextRepositoryMock.findById(id)).thenReturn(appendixTextOptional);
        assertEquals(appendixText, appendixTextService.findById(id));
    }

    @Test
    public void testFindByNotFoundId() {
        Long id = GetRandomLong();
        Optional<AppendixText> empty = Optional.empty();
        when(appendixTextRepositoryMock.findById(id)).thenReturn(empty);
        assertNull(appendixTextService.findById(id));
    }

}