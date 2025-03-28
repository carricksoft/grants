/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 16:14. All rights reserved.
 *
 */

package scot.carricksoftware.grants.bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.services.images.image.ImageService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DataLoadImagesTest {

    private DataLoadImages dataLoadImages;

    @Mock
    private ImageService imageServiceMock;

    @BeforeEach
    void setUp() {
        dataLoadImages = new DataLoadImages(imageServiceMock);
    }

    @Test
    public void anImageIsCreatedTest() {
        ArgumentCaptor<ImageCommand> captor = ArgumentCaptor.forClass(ImageCommand.class);
        dataLoadImages.load();
        verify(imageServiceMock).saveImageCommand(captor.capture());
    }
}