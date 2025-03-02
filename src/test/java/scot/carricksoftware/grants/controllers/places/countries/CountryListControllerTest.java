/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.countries;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.services.places.CountryServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomCountry;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryListControllerTest {

    private CountryListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private CountryServiceImpl countryServiceImplMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Country> countryListMock;

    @Before
    public void setUp() {
        controller = new CountryListControllerImpl(controllerHelperMock, countryServiceImplMock);
    }

    @Test
    public void getListPageTest() {
        when(countryServiceImplMock.getPagedCountries(0)).thenReturn(countryListMock);
        assertEquals("country/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("countries", countryListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(countryServiceImplMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        verify(countryServiceImplMock).getPagedCountries(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/countries", controller.countryDelete(Long.toString(id)));
        verify(countryServiceImplMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(GetRandomCountry());
        when(countryServiceImplMock.getPagedCountries(0)).thenReturn(countryList);

        assertEquals("country/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("countries", countryList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(GetRandomCountry());
        when(countryServiceImplMock.getPagedCountries(0)).thenReturn(countryList);

        controller.getFirstPage(modelMock);
        assertEquals("country/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("countries", countryList);
    }


}
