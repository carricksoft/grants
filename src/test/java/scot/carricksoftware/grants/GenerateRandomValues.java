/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.places.PlaceCommand;
import scot.carricksoftware.grants.commands.places.countries.CountryCommand;
import scot.carricksoftware.grants.commands.places.regions.RegionCommand;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import java.util.Random;

@Component
public class GenerateRandomValues {

    private static final Random rand = new Random();
    @SuppressWarnings("SpellCheckingInspection")
    private static final String[] names = {"Ryland", "Oscar", "Martha", "Brynn"
            , "Euan", "Jack", "Ramsay", "Ally"};

    public static Long GetRandomLong() {
        return rand.nextLong();
    }

    @SuppressWarnings("unused")
    public static Integer GetRandomInt() {
        return rand.nextInt();
    }

    public static String GetRandomString() {
        int random = rand.nextInt(names.length);
        return names[random];
    }

    public static Person GetRandomPerson() {
        Person person = new Person();
        person.setFirstName(GetRandomString());
        person.setLastName(GetRandomString());
        return person;
    }

    public static PersonCommand GetRandomPersonCommand() {
        PersonCommand personCommand = new PersonCommand();
        personCommand.setFirstName(GetRandomString());
        personCommand.setLastName(GetRandomString());
        return personCommand;
    }

    public static Place GetRandomPlace() {
        Place place = new Place();
        place.setCountry(GetRandomCountry());
        place.setRegion(GetRandomRegion());
        place.setName(GetRandomString());
        return place;
    }

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

    public static CountryCommand GetRandomCountryCommand() {
        CountryCommand countryCommand = new CountryCommand();
        countryCommand.setName(GetRandomString());
        return countryCommand;
    }

    public static Region GetRandomRegion() {
        Region region = new Region();
        region.setName(GetRandomString());
        return region;
    }

    public static RegionCommand GetRandomRegionCommand() {
        RegionCommand regionCommand = new RegionCommand();
        regionCommand.setName(GetRandomString());
        return regionCommand;
    }

    @SuppressWarnings("unused")
    public static Census GetRandomCensus() {
        Census census = new Census();
        census.setPlace(GetRandomPlace());
        return census;
    }


}
