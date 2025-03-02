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
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlace;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPlaceCommand;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PlaceFormControllerTest {

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
    public void getNewPlaceTest() {
        Model model = new ExtendedModelMap();
        assertEquals("place/form", placeController.getNewPlace(model));
        assertEquals(PlaceCommand.class, Objects.requireNonNull(model.getAttribute(AttributeConstants.PLACE_COMMAND)).getClass());
    }

    @Test
    public void placeEditTestEditTest() {
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        when(placeServiceMock.findById(id)).thenReturn(place);

        assertEquals("place/form", placeController.placeEdit(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PLACE_COMMAND, place);
    }

    @Test
    public void showByIdTest() {
        Long id = GetRandomLong();
        Place place = GetRandomPlace();
        PlaceCommand placeCommand = GetRandomPlaceCommand();

        when(placeServiceMock.findById(id)).thenReturn(place);
        when(placeConverterMock.convert(place)).thenReturn(placeCommand);
        assertEquals("place/form", placeController.showById(id + "", modelMock));
        verify(modelMock).addAttribute(AttributeConstants.PLACE_COMMAND, placeCommand);
    }

}