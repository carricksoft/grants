/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.organisations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.services.places.organisations.OrganisationService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPlaceValues.GetRandomOrganisation;


@ExtendWith(MockitoExtension.class)
public class OrganisationListControllerTest {

    private OrganisationListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private OrganisationService organisationServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<Organisation> organisationListMock;

    @BeforeEach
    public void setUp() {
        controller = new OrganisationListControllerImpl(controllerHelperMock, organisationServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(organisationServiceMock.getPagedOrganisations(0)).thenReturn(organisationListMock);
        assertEquals("organisation/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("organisations", organisationListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(organisationServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("organisation/list", controller.getLastPage(modelMock));
        verify(organisationServiceMock, times(2)).getPagedOrganisations(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/organisations", controller.organisationDelete(Long.toString(id)));
        verify(organisationServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<Organisation> organisationList = new ArrayList<>();
        organisationList.add(GetRandomOrganisation());
        when(organisationServiceMock.getPagedOrganisations(0)).thenReturn(organisationList);

        assertEquals("organisation/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("organisations", organisationList);
    }

    @Test
    public void getNextPlaceTest() {
        List<Organisation> organisationList = new ArrayList<>();
        organisationList.add(GetRandomOrganisation());
        when(organisationServiceMock.getPagedOrganisations(0)).thenReturn(organisationList);

        controller.getFirstPage(modelMock);
        assertEquals("organisation/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("organisations", organisationList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<Organisation> organisationList = new ArrayList<>();
        organisationList.add(GetRandomOrganisation());
        when(organisationServiceMock.getPagedOrganisations(0)).thenReturn(organisationList);

        controller.getFirstPage(modelMock);
        assertEquals("organisation/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("organisations", organisationList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(organisationServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("organisation/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
