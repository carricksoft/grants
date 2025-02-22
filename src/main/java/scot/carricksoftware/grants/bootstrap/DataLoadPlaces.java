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


    public void load() {
        logger.debug("DataLoadPlaces::load");
        loadCountries();
        loadRegions();
        loadPlaces();
    }

    final Country scotland = new Country();
    final Country england = new Country();
    final Region midlothian = new Region();
    final Region inverness = new Region();


    private void loadCountries() {
        scotland.setName("Scotland");
        countryService.save(scotland);
        england.setName("England");
        countryService.save(england);
    }

    private void loadRegions() {
        midlothian.setName("Midlothian");
        regionService.save(midlothian);
        inverness.setName("Inverness");
        regionService.save(inverness);
    }

    private void loadPlaces() {
        Place wilsonAvenue = new Place();
        wilsonAvenue.setName("2 Wilson Avenue");
        wilsonAvenue.setRegion(midlothian);
        wilsonAvenue.setCountry(scotland);
        placeService.save(wilsonAvenue);

        Place bellFieldPark = new Place();
        bellFieldPark.setName("5 Bellfield Park");
        bellFieldPark.setRegion(inverness);
        bellFieldPark.setCountry(scotland);
        placeService.save(bellFieldPark);
    }
}
