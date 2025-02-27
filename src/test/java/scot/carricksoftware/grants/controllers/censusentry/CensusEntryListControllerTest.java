/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censusentry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.services.censusentry.CensusEntryServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CensusEntryListControllerTest {

    private CensusEntryListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusEntryServiceImpl censusEntryServiceImplMock;

    @Mock
    private Model modelMock;

    @Mock
    List<CensusEntry> censusEntryListMock;

    @BeforeEach
    public void setUp() {
        controller = new CensusEntryListControllerImpl(controllerHelperMock, censusEntryServiceImplMock);
    }

    @Test
    void getListPageTest() {
        when(censusEntryServiceImplMock.getPagedCensusEntries(0)).thenReturn(censusEntryListMock);
        assertEquals("censusentry/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("censusEntries", censusEntryListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(censusEntryServiceImplMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        verify(censusEntryServiceImplMock).getPagedCensusEntries(page);
    }

}
