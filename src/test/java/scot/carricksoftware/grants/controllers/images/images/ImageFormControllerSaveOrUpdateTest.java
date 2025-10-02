/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.converters.images.ConvertToBase64;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.ImageCommandValidator;


@SuppressWarnings("CommentedOutCode")
@ExtendWith(MockitoExtension.class)
public class ImageFormControllerSaveOrUpdateTest {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private ImageFormControllerImpl imageController;

    @Mock
    private ImageService imageServiceMock;

    @Mock
    private ImageCommandConverterImpl imageCommandConverterMock;

    @Mock
    private ImageConverterImpl imageConverterMock;

    @SuppressWarnings("unused")
    @Mock
    Model modelMock;

    @SuppressWarnings("unused")
    @Mock
    BindingResult bindingResultMock;

    @Mock
    private ImageCommandValidator imageCommandValidatorMock;

    @Mock
    ConvertToBase64 convertToBase64Mock;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private ImageCommand imageCommand;


    @BeforeEach
    public void setUp() {
        imageController = new ImageFormControllerImpl(imageServiceMock,
                imageCommandConverterMock,
                imageConverterMock,
                imageCommandValidatorMock,
                convertToBase64Mock);
        imageCommand = new ImageCommandImpl();
    }

//    @Test
//    public void saveOrUpdateNoErrorsTest() {
//        Long id = 4L;
//        imageCommand.setId(id);
//        when(imageServiceMock.saveImageCommand(any(ImageCommand.class))).thenReturn(imageCommand);
//        assertEquals("redirect:/image/4/show", imageController.saveOrUpdate(imageCommand, bindingResultMock, modelMock));
//    }

//    @Test
//    public void saveOrUpdateErrorsTest() {
//        Long id = 4L;
//        imageCommand.setId(id);
//        when(bindingResultMock.hasErrors()).thenReturn(true);
//        assertEquals("images/image/form", imageController.saveOrUpdate(imageCommand, bindingResultMock, modelMock));
//    }

}