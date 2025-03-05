/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.census.CensusCommandImpl;
import scot.carricksoftware.grants.commands.census.CensusEntryCommandImpl;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.commands.places.countries.CountryCommandImpl;
import scot.carricksoftware.grants.commands.places.regions.RegionCommandImpl;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Country;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.domains.places.Region;

import java.time.LocalDate;
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

    @SuppressWarnings("unused")
    public static PersonCommandImpl GetRandomPersonCommand() {
        PersonCommandImpl personCommandImpl = new PersonCommandImpl();
        personCommandImpl.setFirstName(GetRandomString());
        personCommandImpl.setLastName(GetRandomString());
        return personCommandImpl;
    }

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

    @SuppressWarnings("unused")
    public static Census GetRandomCensus() {
        Census census = new Census();
        census.setPlace(GetRandomPlace());
        census.setId(GetRandomLong());
        census.setDate(LocalDate.now().format(ApplicationConstants.FORMATTER));
        return census;
    }

    @SuppressWarnings("unused")
    public static CensusCommandImpl GetRandomCensusCommand() {
        CensusCommandImpl censusCommandImpl = new CensusCommandImpl();
        censusCommandImpl.setPlace(GetRandomPlace());
        censusCommandImpl.setId(GetRandomLong());
        censusCommandImpl.setDate(LocalDate.now().format(ApplicationConstants.FORMATTER));
        return censusCommandImpl;
    }

    @SuppressWarnings("unused")
    public static CensusEntryCommandImpl GetRandomCensusEntryCommand() {
        CensusEntryCommandImpl censusEntryCommandImpl = new CensusEntryCommandImpl();
        censusEntryCommandImpl.setCensus(GetRandomCensus());
        censusEntryCommandImpl.setId(GetRandomLong());
        censusEntryCommandImpl.setPerson(GetRandomPerson());
        censusEntryCommandImpl.setOtherPerson(GetRandomString());
        return censusEntryCommandImpl;
    }

}
