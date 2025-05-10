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
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.census.CensusService;
import scot.carricksoftware.grants.services.census.selectedcensus.SelectedCensusEntryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class SelectedCensusListControllerTest {

    private SelectedCensusListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private SelectedCensusEntryService selectedCensusEntryServiceMock;

    private Model model;

    private Census census;

    @BeforeEach
    public void setUp() {
        controller = new SelectedCensusListControllerImpl(controllerHelperMock,
                selectedCensusEntryServiceMock,
                censusServiceMock);
        model = new ConcurrentModel();
        census = new Census();
    }

    @Test
    public void controllerHelperIsCalledInCensusEntryListTest() {
        when(censusServiceMock.findById(any())).thenReturn(census);
        controller.censusEntryList(GetRandomLong().toString(), model);
        verify(controllerHelperMock).addAttributes(model);
    }

    @Test
    public void controllerHelperIsCalledInGetListPageTest() {
        controller.getListPage(model);
        verify(controllerHelperMock).addAttributes(model);
    }

    @Test
    public void controllerHelperIsCalledInGetNextPageTest() {
        controller.getNextPage(model);
        verify(controllerHelperMock).addAttributes(model);
    }

    @Test
    public void controllerHelperIsCalledInGetPreviousPageTest() {
        controller.getPreviousPage(model);
        verify(controllerHelperMock).addAttributes(model);
    }

    @Test
    public void controllerHelperIsCalledInGetFirstPageTest() {
        controller.getFirstPage(model);
        verify(controllerHelperMock).addAttributes(model);
    }

    @Test
    public void controllerHelperIsCalledInGetLastPageTest() {
        controller.getLastPage(model);
        verify(controllerHelperMock).addAttributes(model);
    }

}
