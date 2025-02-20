/*
 * Copyright (c)  19 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.places.places;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.converters.CapitalisationImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceCommandConverterImpl;
import scot.carricksoftware.grants.converters.places.places.PlaceConverterImpl;
import scot.carricksoftware.grants.services.places.PlaceService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;


@SpringBootTest
class PlaceFormControllerITest {

    @SuppressWarnings("unused")
    private PlaceFormController placeController;

    @Mock
    private PlaceService placeServiceMock;

    @Mock
    private PlaceCommandConverterImpl placeCommandConverterMock;

    @Mock
    private PlaceConverterImpl placeConverterMock;

    @Mock
    private CapitalisationImpl capitalisationMock;

    @BeforeEach
    void setUp() {
        placeController = new PlaceFormControllerImpl(placeServiceMock,
                placeCommandConverterMock,
                placeConverterMock,
                capitalisationMock);
    }

    @Test
    void getNewPlaceTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();

        mockMvc.perform(MockMvcRequestBuilders.get(MappingConstants.PLACE_NEW))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("place/form"));
    }

    @Test
    void PostPlaceTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(placeController).build();
        Long id = GetRandomLong();
        PlaceCommand placeCommand = new PlaceCommand();
        placeCommand.setId(id);
        String expectedViewName = "redirect:/place/" + id + "/show";


        when(placeServiceMock.savePlaceCommand(any(PlaceCommand.class))).thenReturn(placeCommand);

        mockMvc.perform(MockMvcRequestBuilders.post(MappingConstants.PLACE))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name(expectedViewName));
    }


}