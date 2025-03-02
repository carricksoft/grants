/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.places.PlaceServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlaceListControllerTest {

    private PlaceListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private PlaceServiceImpl placeServiceImplMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Place> placeListMock;

    @Before
    public void setUp() {
        controller = new PlaceListControllerImpl(controllerHelperMock, placeServiceImplMock);
    }

    @Test
    public void getListPageTest() {
        when(placeServiceImplMock.getPagedCountries(0)).thenReturn(placeListMock);
        assertEquals("place/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("places", placeListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(placeServiceImplMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        verify(placeServiceImplMock).getPagedCountries(page);
    }

}
