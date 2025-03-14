/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.services.places.countries.CountryService;
import scot.carricksoftware.grants.services.places.regions.RegionService;

@Component
public class DataLoadPlaces {

    private static final Logger logger = LogManager.getLogger(DataLoadPlaces.class);

    private final CountryService countryService;
    private final RegionService regionService;

    public DataLoadPlaces(CountryService countryService,
                          RegionService regionService) {
        this.countryService = countryService;
        this.regionService = regionService;
    }

    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadCountries();
        loadRegions();
    }


    final Country scotland = new Country();
    final Country england = new Country();

    private void loadCountries() {
        scotland.setName("Scotland");
        countryService.save(scotland);
        england.setName("England");
        countryService.save(england);
    }

    private void loadRegions() {
        final Region inverness = new Region();
        final Region midlothian = new Region();

        inverness.setName("Inverness");
        inverness.setCountry(scotland);
        regionService.save(inverness);

        midlothian.setName("Midlothian");
        midlothian.setCountry(scotland);
        regionService.save(midlothian);
    }



}
