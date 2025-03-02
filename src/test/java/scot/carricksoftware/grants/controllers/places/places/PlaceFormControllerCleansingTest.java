/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
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
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PlaceFormControllerCleansingTest {

    @SuppressWarnings("unused")
    private PlaceFormControllerImpl placeController;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private CountryService countryServiceMock;

    @Mock
    private RegionService regionServiceMock;


    @Mock
    private PlaceCommandConverterImpl placeCommandConverterMock;

    @Mock
    private PlaceConverterImpl placeConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @Mock
    private PlaceCommand placeCommandMock;

    @Mock
    private BindingResult bindingResultMock;

    @Mock
    private Model modelMock;


    @Before
    public void setUp() {
        placeController = new PlaceFormControllerImpl(placeServiceMock,
                placeCommandConverterMock,
                placeConverterMock,
                capitalisationMock,
                countryServiceMock,
                regionServiceMock);
    }

    @Test
    public void saveOrUpdateCleansingNameTest() {
        String name = "goat";
        String uName = "Goat";
        when(placeServiceMock.savePlaceCommand(any())).thenReturn(placeCommandMock);
        when(placeCommandMock.getName()).thenReturn(name);
        when(capitalisationMock.getCapitalisation(name)).thenReturn(uName);
        placeController.saveOrUpdate(placeCommandMock, bindingResultMock, modelMock);

        verify(placeCommandMock).setName(uName);
    }


}