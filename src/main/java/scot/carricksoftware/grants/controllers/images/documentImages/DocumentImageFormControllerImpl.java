/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.documentImages;

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
import scot.carricksoftware.grants.capitalisation.images.documentimage.CapitaliseDocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.commands.images.DocumentImageCommandImpl;
import scot.carricksoftware.grants.constants.*;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverter;
import scot.carricksoftware.grants.services.images.documentimage.DocumentImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.validators.images.DocumentImageCommandValidator;


@Controller
public class DocumentImageFormControllerImpl implements DocumentImageFormController {

    private static final Logger logger = LogManager.getLogger(DocumentImageFormControllerImpl.class);
    private final DocumentImageService documentImageService;
    private final DocumentImageConverter documentImageConverter;
    private final DocumentImageCommandValidator documentImageCommandValidator;
    private final ImageService imageService;
    private final CapitaliseDocumentImageCommand capitaliseDocumentImageCommand;

    public DocumentImageFormControllerImpl(DocumentImageService documentImageService,
                                           DocumentImageConverter documentImageConverter,
                                           DocumentImageCommandValidator documentImageCommandValidator,
                                           ImageService imageService,
                                           CapitaliseDocumentImageCommand capitaliseDocumentImageCommand) {
        this.documentImageService = documentImageService;
        this.documentImageConverter = documentImageConverter;
        this.documentImageCommandValidator = documentImageCommandValidator;
        this.imageService = imageService;
        this.capitaliseDocumentImageCommand = capitaliseDocumentImageCommand;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.DOCUMENT_IMAGE_NEW)
    public final String getNewDocumentImage(final Model model) {
        logger.debug("DocumentImageFormControllerImpl::getNewDocumentImage");
        model.addAttribute(ImageAttributeConstants.DOCUMENT_IMAGE_COMMAND, new DocumentImageCommandImpl());
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.DOCUMENT_IMAGE_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.DOCUMENT_IMAGE_EDIT)
    public final String documentImageEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("DocumentImageFormControllerImpl::documentImageEdit");
        model.addAttribute(ImageAttributeConstants.DOCUMENT_IMAGE_COMMAND, documentImageService.findById(Long.valueOf(id)));
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.DOCUMENT_IMAGE_FORM;
    }

    @Override
    @PostMapping(ImageMappingConstants.DOCUMENT_IMAGE)
    public String saveOrUpdate(@Valid @ModelAttribute DocumentImageCommand documentImageCommand, BindingResult bindingResult, Model model) {
        logger.debug("DocumentImageFormControllerImpl::saveOrUpdate");


        capitaliseDocumentImageCommand.capitalise(documentImageCommand);
        documentImageCommandValidator.validate(documentImageCommand, bindingResult);

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
            return ViewConstants.DOCUMENT_IMAGE_FORM;
        }

        DocumentImageCommand savedCommand = documentImageService.saveDocumentImageCommand(documentImageCommand);
        model.addAttribute(ImageAttributeConstants.DOCUMENT_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return MappingConstants.REDIRECT + ImageMappingConstants.DOCUMENT_IMAGE_SHOW.replace("{id}", "" + savedCommand.getId());
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(ImageMappingConstants.DOCUMENT_IMAGE_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("DocumentImageFormControllerImpl::showById");
        DocumentImageCommand savedCommand = documentImageConverter.convert(documentImageService.findById(Long.valueOf(id)));
        model.addAttribute(ImageAttributeConstants.DOCUMENT_IMAGE_COMMAND, savedCommand);
        model.addAttribute(AttributeConstants.IMAGES, imageService.findAll());
        return ViewConstants.DOCUMENT_IMAGE_FORM;
    }


}
