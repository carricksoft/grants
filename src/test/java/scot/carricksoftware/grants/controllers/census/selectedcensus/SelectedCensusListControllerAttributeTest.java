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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class SelectedCensusListControllerAttributeTest {

    private SelectedCensusListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusService censusServiceMock;

    @Mock
    private SelectedCensusEntryService selectedCensusEntryServiceMock;

    private Model model;

    @BeforeEach
    public void setUp() {
        controller = new SelectedCensusListControllerImpl(controllerHelperMock,
                selectedCensusEntryServiceMock,
                censusServiceMock);
        model = new ConcurrentModel();
        Census census = new Census();
        when(censusServiceMock.findById(any())).thenReturn(census);
    }

    @Test
    public void censusEntryListTest() {
        controller.censusEntryList(GetRandomLong().toString(), model);
        assertTrue(model.containsAttribute("censusEntries"));
    }

    @Test
    public void getListPageTest() {
        controller.censusEntryList(GetRandomLong().toString(), model);
        controller.getListPage(model);
        assertTrue(model.containsAttribute("censusEntries"));
        assertTrue(model.containsAttribute("census"));
    }


}
