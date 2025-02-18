/*
 * Copyright (c)  18 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.exceptions.GrantsException;
import scot.carricksoftware.grants.services.places.CountryService;
import scot.carricksoftware.grants.services.places.PlaceService;
import scot.carricksoftware.grants.services.places.RegionService;

@Component
public class DataLoadPlaces {

    private static final Logger logger = LogManager.getLogger(DataLoadPlaces.class);

    private final CountryService countryService;
    private final RegionService regionService;
    private final PlaceService placeService;

    public DataLoadPlaces(CountryService countryService, RegionService regionService, PlaceService placeService) {
        this.countryService = countryService;
        this.regionService = regionService;
        this.placeService = placeService;
    }


    public void load() throws GrantsException {
        logger.debug("DataLoadPlaces::load");
        loadCountries();
        loadRegions();
        loadPlaces();
    }

    final Country scotland = new Country();
    final Region midlothian = new Region();

    private void loadCountries() {
        scotland.setName("Scotland");
        countryService.save(scotland);
    }

    private void loadRegions() {
        midlothian.setName("Midlothian");
        regionService.save(midlothian);
    }

    private void loadPlaces() throws GrantsException {
        Place wilsonAvenue = new Place();
        wilsonAvenue.setName("Wilson Avenue");
        wilsonAvenue.setRegion(midlothian);
        wilsonAvenue.setCountry(scotland);
        placeService.save(wilsonAvenue);
    }
}
