/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.appendixtext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.TextAttributeConstants;
import scot.carricksoftware.grants.constants.TextMappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.text.appendixtext.AppendixTextService;

import static java.lang.Integer.max;

@Controller
public class AppendixTextListControllerImpl implements AppendixTextListController {

    private static final Logger logger = LogManager.getLogger(AppendixTextListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final AppendixTextService appendixTextService;

    public AppendixTextListControllerImpl(ControllerHelper controllerHelper,
                                          AppendixTextService appendixTextService) {
        this.controllerHelper = controllerHelper;
        this.appendixTextService = appendixTextService;
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("AppendixTextListControllerImpl::getImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(TextAttributeConstants.APPENDIX_TEXTS, appendixTextService.getPagedAppendixTexts(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.APPENDIX_TEXT_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("AppendixTextListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("AppendixTextListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("AppendixTextListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("AppendixTextListControllerImpl::getLastPage");
        long imageCount = appendixTextService.count();
        currentPage = (int) (imageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_DELETE)
    @Override
    public final String appendixTextDelete(@PathVariable final String id) {
        logger.debug("AppendixTextListControllerImpl::imageDelete");
        appendixTextService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + TextMappingConstants.APPENDIX_TEXT_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }
    
}
