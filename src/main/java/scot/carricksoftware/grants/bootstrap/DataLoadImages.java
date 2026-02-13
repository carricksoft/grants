/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.*;
import scot.carricksoftware.grants.services.images.appendiximage.AppendixImageService;
import scot.carricksoftware.grants.services.images.documentimage.DocumentImageService;
import scot.carricksoftware.grants.services.images.image.ImageService;
import scot.carricksoftware.grants.services.images.personimage.PersonImageService;
import scot.carricksoftware.grants.services.images.placeimage.PlaceImageService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

@Component
@Profile("dev")
public class DataLoadImages {

    private static final Logger logger = LogManager.getLogger(DataLoadImages.class);


    private final ImageService imageService;

    private final PersonImageService personImageService;
    private final PlaceImageService placeImageService;
    private final AppendixImageService appendixImageService;
    private final DocumentImageService documentImageService;
    private final PlaceService placeService;



    public DataLoadImages(ImageService imageService,
                          PersonImageService personImageService,
                          PlaceImageService placeImageService,
                          AppendixImageService appendixImageService,
                          DocumentImageService documentImageService,
                          PlaceService placeService) {
        this.imageService = imageService;
        this.personImageService = personImageService;
        this.placeImageService = placeImageService;
        this.appendixImageService = appendixImageService;
        this.documentImageService = documentImageService;
        this.placeService = placeService;
    }

    public void load() {
        logger.debug("DataLoadCensus::load");
        loadImage();
        loadPersonImage();
        loadPlaceImage();
        loadAppendixImage();
        loadDocumentImage();
    }

    private void loadImage() {
        logger.debug("DataLoadCensus::loadImage");
        ImageCommand imageCommand = new ImageCommandImpl();
        imageCommand.setName("Dalkeith");
        imageCommand.setFileName("Midlothian");

        imageService.saveImageCommand(imageCommand);
    }

    private void loadPersonImage() {
        logger.debug("DataLoadCensus::loadPersonImage");
        PersonImageCommand command = new PersonImageCommandImpl();
        command.setImage(imageService.findById(1L));
        command.setCaption("Person caption");

        personImageService.savePersonImageCommand(command);
    }

    private void loadPlaceImage() {
        logger.debug("DataLoadCensus::loadPlaceImage");

        PlaceImageCommand imageCommand = new PlaceImageCommandImpl();
        imageCommand.setPlace(placeService.findById(1L));
        imageCommand.setOrder("7");
        imageCommand.setLevel("8");
        imageCommand.setCaption("Oban");
        imageCommand.setHeight("800");
        imageCommand.setWidth("9");

        placeImageService.savePlaceImageCommand(imageCommand);
    }

    private void loadAppendixImage() {
        logger.debug("DataLoadCensus::loadAppendixImage");
        AppendixImageCommand appendixImageCommand = new AppendixImageCommandImpl();
        appendixImageCommand.setImage(imageService.findById(1L));
        appendixImageCommand.setCaption("Appendix caption");

        appendixImageService.saveAppendixImageCommand(appendixImageCommand);
    }

    private void loadDocumentImage() {
        logger.debug("DataLoadCensus::loadDocumentImage");
        DocumentImageCommand documentImageCommand = new DocumentImageCommandImpl();
        documentImageCommand.setImage(imageService.findById(1L));
        documentImageCommand.setCaption("Document caption");

        documentImageService.saveDocumentImageCommand(documentImageCommand);
    }



}
