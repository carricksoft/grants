/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.appendiximages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.images.appendixImages.AppendixImageListControllerImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;


@ExtendWith(MockitoExtension.class)
public class AppendixImageTextListControllerTest {

    private AppendixImageListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private AppendixImageService appendixImageServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<AppendixImage> appendixImageListMock;

    @BeforeEach
    public void setUp() {
        controller = new AppendixImageListControllerImpl(controllerHelperMock, appendixImageServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(appendixImageServiceMock.getPagedAppendixImages(0)).thenReturn(appendixImageListMock);
        assertEquals("images/appendixImage/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("appendixImages", appendixImageListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(appendixImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("images/appendixImage/list", controller.getLastPage(modelMock));
        verify(appendixImageServiceMock, times(2)).getPagedAppendixImages(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/appendixImages", controller.appendixImageDelete(Long.toString(id)));
        verify(appendixImageServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<AppendixImage> appendixImageList = new ArrayList<>();
        appendixImageList.add(new AppendixImage());
        when(appendixImageServiceMock.getPagedAppendixImages(0)).thenReturn(appendixImageList);

        assertEquals("images/appendixImage/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("appendixImages", appendixImageList);
    }

    @Test
    public void getNextPlaceTest() {
        List<AppendixImage> appendixImageList = new ArrayList<>();
        appendixImageList.add(new AppendixImage());
        when(appendixImageServiceMock.getPagedAppendixImages(0)).thenReturn(appendixImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/appendixImage/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("appendixImages", appendixImageList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<AppendixImage> appendixImageList = new ArrayList<>();
        appendixImageList.add(new AppendixImage());
        when(appendixImageServiceMock.getPagedAppendixImages(0)).thenReturn(appendixImageList);

        controller.getFirstPage(modelMock);
        assertEquals("images/appendixImage/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("appendixImages", appendixImageList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(appendixImageServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("images/appendixImage/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
