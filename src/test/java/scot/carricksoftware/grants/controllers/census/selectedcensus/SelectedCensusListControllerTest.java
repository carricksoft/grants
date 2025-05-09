/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.selectedcensus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.selectedcensus.SelectedCensusEntryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;


@ExtendWith(MockitoExtension.class)
public class SelectedCensusListControllerTest {

    private SelectedCensusListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private SelectedCensusEntryService selectedCensusEntryServiceMock;

    @Mock
    private Model modelMock;

    @SuppressWarnings("unused")
    @Mock
    List<Census> censusListMock;

    @SuppressWarnings("unused")
    private Census census;

    private ArgumentCaptor<String> stringCaptor;
    private ArgumentCaptor<Object> objectCaptor;

    @BeforeEach
    public void setUp() {
        stringCaptor = ArgumentCaptor.forClass(String.class);
        objectCaptor = ArgumentCaptor.forClass(Object.class);
        controller = new SelectedCensusListControllerImpl(controllerHelperMock,
                selectedCensusEntryServiceMock,
                censusServiceMock);

    }

    @Test
    public void getListPageTest() {
        assertEquals("selectedCensus/list", controller.getListPage(modelMock));

        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertTrue(stringCaptor.getAllValues().contains("census"));
        assertTrue(stringCaptor.getAllValues().contains("censusEntries"));

    }

    @SuppressWarnings("unused")
    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;

        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertTrue(stringCaptor.getAllValues().contains("census"));
        assertTrue(stringCaptor.getAllValues().contains("censusEntries"));

    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public void getFirstPlaceTest() {
        List<Census> censusList = new ArrayList<>();
        censusList.add(GetRandomCensus());

        assertEquals("selectedCensus/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertTrue(stringCaptor.getAllValues().contains("census"));
        assertTrue(stringCaptor.getAllValues().contains("censusEntries"));
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public void getNextPlaceTest() {
        List<Census> censusList = new ArrayList<>();
        censusList.add(GetRandomCensus());

        controller.getFirstPage(modelMock);
        assertEquals("selectedCensus/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertTrue(stringCaptor.getAllValues().contains("census"));
        assertTrue(stringCaptor.getAllValues().contains("censusEntries"));

    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public void getPreviousFromFirstTest() {
        List<Census> censusList = new ArrayList<>();
        censusList.add(GetRandomCensus());

        controller.getFirstPage(modelMock);
        assertEquals("selectedCensus/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, atLeast(2)).addAttribute(stringCaptor.capture(), objectCaptor.capture());
        assertTrue(stringCaptor.getAllValues().contains("census"));
        assertTrue(stringCaptor.getAllValues().contains("censusEntries"));
    }




}
