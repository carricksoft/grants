/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.people.PersonFormControllerImpl;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonServiceImpl;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SuppressWarnings({"SpellCheckingInspection", "CommentedOutCode"})
@SpringBootTest
class NotFoundExceptionTest {

    @Mock
    PersonServiceImpl personServiceMock;

    @SuppressWarnings("unused")
    @Mock
    ControllerHelper controllerHelperMock;

    @Mock
    PersonCommandConverterImpl personCommandConverterMock;

    @Mock
    PersonConverterImpl personConverterMock;

    PersonFormControllerImpl personFormController;

    MockMvc mockMvcForm;


    @BeforeEach
    public void setUp() {

        personFormController = new PersonFormControllerImpl(personServiceMock,personCommandConverterMock,personConverterMock);

        mockMvcForm = MockMvcBuilders.standaloneSetup(personFormController).build();
    }

    @Test
    public void testGetRecipe() throws Exception {
       Person person = new Person();
        person.setId(1L);

        when(personServiceMock.findById(anyLong())).thenReturn(person);

        mockMvcForm.perform(MockMvcRequestBuilders.get("/person/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("person/form"));
    }

    @Test
    public void getPersonNotFound() throws Exception {

        when(personServiceMock.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvcForm.perform(MockMvcRequestBuilders.get("/person/1/show"))
                .andExpect(status().isNotFound());
    }

//    @Test
//    public void testGetNewRecipeForm() throws Exception {
//        RecipeCommand command = new RecipeCommand();
//
//        mockMvc.perform(get("/recipe/new"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("recipe/recipeform"))
//                .andExpect(model().attributeExists("recipe"));
//    }
//
//    @Test
//    public void testPostNewRecipeForm() throws Exception {
//        RecipeCommand command = new RecipeCommand();
//        command.setId(2L);
//
//        when(recipeService.saveRecipeCommand(any())).thenReturn(command);
//
//        mockMvc.perform(post("/recipe")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("id", "")
//                        .param("description", "some string")
//                )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/recipe/2/show"));
//    }
//
//    @Test
//    public void testGetUpdateView() throws Exception {
//        RecipeCommand command = new RecipeCommand();
//        command.setId(2L);
//
//        when(recipeService.findCommandById(anyLong())).thenReturn(command);
//
//        mockMvc.perform(get("/recipe/1/update"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("recipe/recipeform"))
//                .andExpect(model().attributeExists("recipe"));
//    }
//
//    @Test
//    public void testDeleteAction() throws Exception {
//        mockMvc.perform(get("/recipe/1/delete"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/"));
//
//        verify(recipeService, times(1)).deleteById(anyLong());
//    }
}


