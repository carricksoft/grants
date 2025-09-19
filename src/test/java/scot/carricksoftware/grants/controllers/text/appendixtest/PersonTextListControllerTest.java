/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.appendixtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.controllers.text.appendixtext.AppendixTextListControllerImpl;
import scot.carricksoftware.grants.domains.text.AppendixText;
import scot.carricksoftware.grants.services.text.appendixtext.AppendixTextService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomTextValues.GetRandomAppendixText;


@ExtendWith(MockitoExtension.class)
public class PersonTextListControllerTest {

    private AppendixTextListControllerImpl controller;

    @Mock
    private ControllerHelper controllerHelperMock;

    @Mock
    private AppendixTextService appendixTextServiceMock;

    @Mock
    private Model modelMock;

    @Mock
    List<AppendixText> appendixTextListMock;

    @BeforeEach
    public void setUp() {
        controller = new AppendixTextListControllerImpl(controllerHelperMock, appendixTextServiceMock);
    }

    @Test
    public void getListPageTest() {
        when(appendixTextServiceMock.getPagedAppendixTexts(0)).thenReturn(appendixTextListMock);
        assertEquals("text/appendixText/list", controller.getListPage(modelMock));
        verify(modelMock).addAttribute("appendixTexts", appendixTextListMock);
        verify(controllerHelperMock).addAttributes(modelMock);
    }

    @Test
    public void getLastPageTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(appendixTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        controller.getPreviousPage(modelMock);
        assertEquals("text/appendixText/list", controller.getLastPage(modelMock));
        verify(appendixTextServiceMock, times(2)).getPagedAppendixTexts(page);
    }

    @Test
    public void placeDeleteTest() {
        Long id = GetRandomLong();
        assertEquals("redirect:/appendixTexts", controller.appendixTextDelete(Long.toString(id)));
        verify(appendixTextServiceMock).deleteById(id);
    }

    @Test
    public void getFirstPlaceTest() {
        List<AppendixText> appendixTextList = new ArrayList<>();
        appendixTextList.add(GetRandomAppendixText());
        when(appendixTextServiceMock.getPagedAppendixTexts(0)).thenReturn(appendixTextList);

        assertEquals("text/appendixText/list", controller.getFirstPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock).addAttribute("appendixTexts", appendixTextList);
    }

    @Test
    public void getNextPlaceTest() {
        List<AppendixText> appendixTextList = new ArrayList<>();
        appendixTextList.add(GetRandomAppendixText());
        when(appendixTextServiceMock.getPagedAppendixTexts(0)).thenReturn(appendixTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/appendixText/list", controller.getNextPage(modelMock));
        assertEquals(1, controller.getPageNumber());
        verify(modelMock).addAttribute("appendixTexts", appendixTextList);

    }

    @Test
    public void getPreviousFromFirstTest() {
        List<AppendixText> appendixTextList = new ArrayList<>();
        appendixTextList.add(GetRandomAppendixText());
        when(appendixTextServiceMock.getPagedAppendixTexts(0)).thenReturn(appendixTextList);

        controller.getFirstPage(modelMock);
        assertEquals("text/appendixText/list", controller.getPreviousPage(modelMock));
        assertEquals(0, controller.getPageNumber());
        verify(modelMock, times(2)).addAttribute("appendixTexts", appendixTextList);
    }

    @Test
    public void getPreviousFromLastTest() {
        int page = 25;
        int count = page * ApplicationConstants.DEFAULT_PAGE_SIZE;
        when(appendixTextServiceMock.count()).thenReturn((long) count);
        controller.getLastPage(modelMock);
        assertEquals("text/appendixText/list", controller.getPreviousPage(modelMock));
        assertEquals(24, controller.getPageNumber());
    }


}
