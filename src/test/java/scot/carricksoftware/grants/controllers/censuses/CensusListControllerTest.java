/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.censuses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.census.CensusListControllerImpl;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.services.census.CensusServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CensusListControllerTest {

    private CensusListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CensusServiceImpl censusServiceImplMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Census> censusListMock;

    @BeforeEach
    public void setUp() {
        controller = new CensusListControllerImpl(controllerHelperMock, censusServiceImplMock);
    }

    @Test
    void getListPageTest() {
        when(censusServiceImplMock.getPagedCensuses(0)).thenReturn(censusListMock);
        assertEquals("census/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("censuses", censusListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(censusServiceImplMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        verify(censusServiceImplMock).getPagedCensuses(page);
    }

}
