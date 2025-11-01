/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.appendixImages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.constants.ImageAttributeConstants;
import scot.carricksoftware.grants.constants.ImageMappingConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.controllers.ControllerHelper;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;

import static java.lang.Integer.max;

@Controller
public class AppendixImageListControllerImpl implements AppendixImageListController {

    private static final Logger logger = LogManager.getLogger(AppendixImageListControllerImpl.class);


    private int currentPage = 0;
    private final ControllerHelper controllerHelper;
    private final AppendixImageService appendixImageService;

    public AppendixImageListControllerImpl(ControllerHelper controllerHelper,
                                           AppendixImageService appendixImageService) {
        this.controllerHelper = controllerHelper;
        this.appendixImageService = appendixImageService;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_LIST)
    @Override
    public final String getListPage(final Model model) {
        logger.debug("PersonListControllerImpl::getPersonImagePage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    private String sendAttributesAndReturn(Model model) {
        model.addAttribute(ImageAttributeConstants.APPENDIX_IMAGES, appendixImageService.getPagedAppendixImages(currentPage));
        controllerHelper.addAttributes(model);
        return ViewConstants.APPENDIX_IMAGE_LIST;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_NEXT)
    @Override
    public final String getNextPage(final Model model) {
        logger.debug("AppendixImageListControllerImpl::getNextPage");
        currentPage++;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_PREVIOUS)
    @Override
    public final String getPreviousPage(final Model model) {
        logger.debug("AppendixImageListControllerImpl::getPreviousPage");
        currentPage = max(0, currentPage - 1);
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_REWIND)
    public final String getFirstPage(final Model model) {
        logger.debug("AppendixImageListControllerImpl::getFirstPage");
        currentPage = 0;
        return sendAttributesAndReturn(model);
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_FF)
    @Override
    public final String getLastPage(final Model model) {
        logger.debug("AppendixImageListControllerImpl::getLastPage");
        long personImageCount = appendixImageService.count();
        currentPage = (int) (personImageCount / ApplicationConstants.DEFAULT_PAGE_SIZE);
        return sendAttributesAndReturn(model);
    }


    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_DELETE)
    @Override
    public final String appendixImageDelete(@PathVariable final String id) {
        logger.debug("AppendixImageListControllerImpl::personImageDelete");
        appendixImageService.deleteById(Long.valueOf(id));
        return MappingConstants.REDIRECT + ImageMappingConstants.APPENDIX_IMAGE_LIST;
    }

    @Override
    public int getPageNumber() {
        return currentPage;
    }


}
