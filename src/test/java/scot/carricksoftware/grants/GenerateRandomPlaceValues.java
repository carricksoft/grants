/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;


import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomString;

@SuppressWarnings("unused")
@Component
public class GenerateRandomPlaceValues {

    @SuppressWarnings("unused")
    public static Place GetRandomPlace() {
        Place place = new Place();
        place.setCountry(GetRandomCountry());
        place.setRegion(GetRandomRegion());
        place.setName(GetRandomString());
        return place;
    }

    @SuppressWarnings("unused")
    public static PlaceCommand GetRandomPlaceCommand() {
        PlaceCommand placeCommand = new PlaceCommand();
        placeCommand.setCountry(GetRandomCountry());
        placeCommand.setRegion(GetRandomRegion());
        placeCommand.setName(GetRandomString());
        return placeCommand;
    }

    public static Country GetRandomCountry() {
        Country country = new Country();
        country.setName(GetRandomString());
        return country;
    }

    @SuppressWarnings("unused")
    public static CountryCommandImpl GetRandomCountryCommand() {
        CountryCommandImpl countryCommandImpl = new CountryCommandImpl();
        countryCommandImpl.setName(GetRandomString());
        return countryCommandImpl;
    }

    public static Region GetRandomRegion() {
        Region region = new Region();
        region.setName(GetRandomString());
        return region;
    }

    @SuppressWarnings("unused")
    public static RegionCommandImpl GetRandomRegionCommand() {
        RegionCommandImpl regionCommandImpl = new RegionCommandImpl();
        regionCommandImpl.setName(GetRandomString());
        return regionCommandImpl;
    }


}
