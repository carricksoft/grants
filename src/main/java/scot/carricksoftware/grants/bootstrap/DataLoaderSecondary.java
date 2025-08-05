/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("dev")
public class DataLoaderSecondary {


    private static final Logger logger = LogManager.getLogger(DataLoaderSecondary.class);

    private final DataLoadCertificates dataLoadCertificates;
    private final DataLoadTexts dataLoadTexts;
    private final DataLoadImages dataLoadImages;

    public DataLoaderSecondary(DataLoadCertificates dataLoadCertificates,
                               DataLoadTexts dataLoadTexts,
                               DataLoadImages dataLoadImages) {
        this.dataLoadCertificates = dataLoadCertificates;
        this.dataLoadTexts = dataLoadTexts;
        this.dataLoadImages = dataLoadImages;
    }

    public void load() {
        logger.debug("DataLoaderSecondary::load");
        dataLoadCertificates.load();
        dataLoadImages.load();
        dataLoadTexts.load();
    }

}
