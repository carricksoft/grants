/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.converters.images.ConvertToBase64;
import scot.carricksoftware.grants.converters.images.image.ImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.image.ImageConverterImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.ImageCommandValidator;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ImageFormControllerSaveOrUpdateTest {

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

    @Mock
    MultipartFile fileMock;

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

    @Test
    public void saveOrUpdateReturnNoErrorsTest() throws IOException {
        Long id = 4L;
        imageCommand.setId(id);
        when(imageServiceMock.saveImageCommand(any(ImageCommand.class))).thenReturn(imageCommand);
        assertEquals("redirect:/image/4/show", imageController.saveOrUpdate(imageCommand, fileMock,bindingResultMock, modelMock));
    }

    @Test
    public void saveOrUpdateReturnErrorsTest() throws IOException {
        Long id = 4L;
        imageCommand.setId(id);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        assertEquals("images/image/form", imageController.saveOrUpdate(imageCommand, fileMock, bindingResultMock, modelMock));
    }


}