/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.services.places.RegionServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RegionListControllerTest {

    private RegionListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private RegionServiceImpl regionServiceImplMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Region> regionListMock;

    @BeforeEach
    public void setUp() {
        controller = new RegionListControllerImpl(controllerHelperMock, regionServiceImplMock);
    }

    @Test
    void getListPageTest() {
        when(regionServiceImplMock.getPagedCountries(0)).thenReturn(regionListMock);
        assertEquals("region/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("regions", regionListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(regionServiceImplMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        verify(regionServiceImplMock).getPagedCountries(page);
    }

}
