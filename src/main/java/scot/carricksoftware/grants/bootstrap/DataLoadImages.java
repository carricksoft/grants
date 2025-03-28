/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.commands.images.ImageCommandImpl;
import scot.carricksoftware.grants.services.images.image.ImageService;

@Component
public class DataLoadImages {

    private static final Logger logger = LogManager.getLogger(DataLoadImages.class);


    private final ImageService imageService;

    public DataLoadImages(ImageService imageService) {
        this.imageService = imageService;
    }

    public void load() {
        logger.debug("DataLoadCensus::load");
        loadImage();
    }

    private void loadImage() {
        logger.debug("DataLoadCensus::loadCensus");
        ImageCommand imageCommand = new ImageCommandImpl();

        imageService.saveImageCommand(imageCommand);
    }




}
