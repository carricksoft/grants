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
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.selectedcensus.SelectedCensusEntryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SelectedCensusListControllerPageNumberTest {

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
        controller.getListPage(modelMock);
        assertEquals(0, controller.getPageNumber());
    }

    @Test
    public void getNextPlaceTest() {
        controller.getListPage(modelMock);
        int page = controller.getPageNumber();
        controller.getNextPage(modelMock);
        assertEquals(page + 1, controller.getPageNumber());
    }

    @Test
    public void getPreviousPlaceZeroTest() {
        controller.getListPage(modelMock);
        assertEquals(0, controller.getPageNumber());
        controller.getPreviousPage(modelMock);
        assertEquals(0, controller.getPageNumber());
    }

    @Test
    public void getPreviousPlaceNonZeroTest() {
        controller.getListPage(modelMock);
        final int ten = 10;
        do {
            controller.getNextPage(modelMock);
        } while (controller.getPageNumber() < ten);
        controller.getPreviousPage(modelMock);
        assertEquals(ten - 1, controller.getPageNumber());
    }

    @Test
    public void getLastPlaceTest() {
        final int pageCount = 10;
        when(selectedCensusEntryServiceMock.count()).thenReturn((long) (pageCount * ApplicationConstants.DEFAULT_PAGE_SIZE));
        controller.getLastPage(modelMock);
        assertEquals(pageCount, controller.getPageNumber());
    }

}
