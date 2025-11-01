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
    private final PlaceService placeService;



    public DataLoadImages(ImageService imageService,
                          PersonImageService personImageService,
                          PlaceImageService placeImageService,
                          AppendixImageService appendixImageService,
                          PlaceService placeService) {
        this.imageService = imageService;
        this.personImageService = personImageService;
        this.placeImageService = placeImageService;
        this.appendixImageService = appendixImageService;
        this.placeService = placeService;
    }

    public void load() {
        logger.debug("DataLoadCensus::load");
        loadImage();
        loadPersonImage();
        loadPlaceImage();
        loadAppendixImage();
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

        personImageService.savePersonImageCommand(command);
    }

    private void loadPlaceImage() {
        logger.debug("DataLoadCensus::loadPlaceImage");

        PlaceImageCommand imageCommand = new PlaceImageCommandImpl();
        imageCommand.setPlace(placeService.findById(1L));

        placeImageService.savePlaceImageCommand(imageCommand);
    }

    private void loadAppendixImage() {
        logger.debug("DataLoadCensus::loadAppendixImage");
        AppendixImageCommand appendixCommand = new AppendixImageCommandImpl();
        appendixCommand.setImage(imageService.findById(1L));

        appendixImageService.saveAppendixImageCommand(appendixCommand);
    }



}
