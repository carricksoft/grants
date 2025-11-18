/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.documentimages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.images.documentImages.DocumentImageListControllerImpl;
import scot.carricksoftware.grants.domains.images.DocumentImage;
import scot.carricksoftware.grants.services.images.documentimage.DocumentImageService;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class DocumentImageTextListControllerTest {

    private DocumentImageListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private DocumentImageService documentImageServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<DocumentImage> documentImageListMock;

    @BeforeEach
    public void setUp() {
        controller = new DocumentImageListControllerImpl(controllerHelperMock, documentImageServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(documentImageServiceMock.getPagedDocumentImages(0)).thenReturn(documentImageListMock);
        assertEquals("images/documentImage/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("documentImages", documentImageListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(documentImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("images/documentImage/list", controller.getLastPage(modelMock));
        verify(documentImageServiceMock, times(2)).getPagedDocumentImages(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/documentImages", controller.documentImageDelete(Long.toString(id)));
        verify(documentImageServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<DocumentImage> documentImageList = new ArrayList<>();
        documentImageList.add(new DocumentImage());
        when(documentImageServiceMock.getPagedDocumentImages(0)).thenReturn(documentImageList);

        assertEquals("images/documentImage/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("documentImages", documentImageList);
    }

    @Test
    public void getNextPlaceTest() {
        List<DocumentImage> documentImageList = new ArrayList<>();
        documentImageList.add(new DocumentImage());
        when(documentImageServiceMock.getPagedDocumentImages(0)).thenReturn(documentImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/documentImage/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("documentImages", documentImageList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<DocumentImage> documentImageList = new ArrayList<>();
        documentImageList.add(new DocumentImage());
        when(documentImageServiceMock.getPagedDocumentImages(0)).thenReturn(documentImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/documentImage/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("documentImages", documentImageList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(documentImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("images/documentImage/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
