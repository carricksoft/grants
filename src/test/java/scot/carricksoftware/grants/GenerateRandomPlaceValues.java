/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;

@SuppressWarnings("unused")
@Component
public class GenerateRandomPlaceValues {


    public static Place GetRandomPlace() {
        Place place = new Place();
        place.setName(GetRandomString());
        return place;
    }

    public static Region GetRandomRegion() {
        Region region  = new Region();
        region.setName(GetRandomString());
        return region;
    }

    public static Country GetRandomCountry() {
        Country country  = new Country();
        country.setName(GetRandomString());
        return country;
    }


}
