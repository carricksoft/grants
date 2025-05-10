/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:30. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.selectedcensus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.selectedcensus.SelectedCensusEntryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class SelectedCensusListControllerReturnValueTest {

    private SelectedCensusListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private SelectedCensusEntryService selectedCensusEntryServiceMock;

    @Mock
    private Model modelMock;

    @BeforeEach
    public void setUp() {
        controller = new SelectedCensusListControllerImpl(controllerHelperMock,
                selectedCensusEntryServiceMock,
                censusServiceMock);
    }

    @Test
    public void getListPageTest() {
        assertEquals("selectedCensus/list", controller.getListPage(modelMock));
    }

    @Test
    public void getLastPageTest() {
        assertEquals("selectedCensus/list", controller.getLastPage(modelMock));
    }

    @Test
    public void getFirstPlaceTest() {
        assertEquals("selectedCensus/list", controller.getFirstPage(modelMock));
    }

    @Test
    public void getNextPlaceTest() {
        assertEquals("selectedCensus/list", controller.getNextPage(modelMock));
    }

    @Test
    public void getPreviousPageTest() {
        assertEquals("selectedCensus/list", controller.getPreviousPage(modelMock));
    }

    @Test
    public void getCensusEntryListTest() {
        assertEquals("selectedCensus/list", controller.censusEntryList(GetRandomLong().toString(),modelMock));
    }


}
