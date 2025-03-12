/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootloader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.services.places.countries.CountryService;

@Component
public class DataLoadPlaces {

    private static final Logger logger = LogManager.getLogger(DataLoadPlaces.class);

    private final CountryService countryService;

    public DataLoadPlaces(CountryService countryService) {
        this.countryService = countryService;
    }


    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadCountries();
    }


    private void loadCountries() {
        final Country scotland = new Country();
        final Country england = new Country();

        scotland.setName("Scotland");
        countryService.save(scotland);
        england.setName("England");
        countryService.save(england);
    }


}
