/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.appendixImages;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grants.capitalisation.images.appendiximage.CapitaliseAppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.commands.images.AppendixImageCommandImpl;
import scot.carricksoftware.grants.constants.AttributeConstants;
import scot.carricksoftware.grants.constants.ImageAttributeConstants;
import scot.carricksoftware.grants.constants.ImageMappingConstants;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.AppendixImageCommandValidatorImpl;


@Controller
public class AppendixImageFormControllerImpl implements AppendixImageFormController {

    private static final Logger logger = LogManager.getLogger(AppendixImageFormControllerImpl.class);
    private final AppendixImageService appendixImageService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final AppendixImageCommandConverterImpl appendixImageCommandConverter;
    private final AppendixImageConverterImpl appendixImageConverter;
    private final AppendixImageCommandValidatorImpl appendixImageCommandValidatorImpl;
    private final ImageService imageService;
    private final CapitaliseAppendixImageCommand capitaliseAppendixImageCommand;


    public AppendixImageFormControllerImpl(AppendixImageService appendixImageService,
                                           AppendixImageCommandConverterImpl appendixImageCommandConverter,
                                           AppendixImageConverterImpl appendixImageConverter,
                                           AppendixImageCommandValidatorImpl appendixImageCommandValidatorImpl,
                                           ImageService imageService,
                                           CapitaliseAppendixImageCommand capitaliseAppendixImageCommand) {

        this.appendixImageService = appendixImageService;
        this.appendixImageCommandConverter = appendixImageCommandConverter;
        this.appendixImageConverter = appendixImageConverter;
        this.appendixImageCommandValidatorImpl = appendixImageCommandValidatorImpl;
        this.imageService = imageService;
        this.capitaliseAppendixImageCommand = capitaliseAppendixImageCommand;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_NEW)
    public final String getNewAppendixImage(final Model model) {
        logger.debug("AppendixImageFormControllerImpl::getNewAppendixImage");
        model.addAttribute(ImageAttributeConstants.APPENDIX_IMAGE_COMMAND, new AppendixImageCommandImpl());
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.APPENDIX_IMAGE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_EDIT)
    public final String appendixImageEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("AppendixImageFormControllerImpl::appendixImageEdit");
        model.addAttribute(ImageAttributeConstants.APPENDIX_IMAGE_COMMAND, appendixImageService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.APPENDIX_IMAGE_FORM;
    }

    @Override
    @PostMapping(ImageMappingConstants.APPENDIX_IMAGE)
    public String saveOrUpdate(@Valid @ModelAttribute AppendixImageCommand appendixImageCommand, BindingResult bindingResult, Model model) {
        logger.debug("AppendixImageFormControllerImpl::saveOrUpdate");

        capitaliseAppendixImageCommand.capitalise(appendixImageCommand);
        appendixImageCommandValidatorImpl.validate(appendixImageCommand, bindingResult);

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
            return ViewConstants.APPENDIX_IMAGE_FORM;
        }

        AppendixImageCommand savedCommand = appendixImageService.saveAppendixImageCommand(appendixImageCommand);
        model.addAttribute(ImageAttributeConstants.APPENDIX_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return MappingConstants.REDIRECT + ImageMappingConstants.APPENDIX_IMAGE_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.APPENDIX_IMAGE_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("AppendixImageFormControllerImpl::showById");
        AppendixImageCommand savedCommand = appendixImageConverter.convert(appendixImageService.findById(Long.valueOf(id)));
        model.addAttribute(ImageAttributeConstants.APPENDIX_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.APPENDIX_IMAGE_FORM;
    }


}
