/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.services.people.PersonService;
import scot.carricksoftware.grants.services.places.places.PlaceService;

import java.util.List;

@Component
public class BMDCacheImpl implements BMDCache {

    private final PersonService personService;
    private final PlaceService placeService;

    private List<Person> people = null;
    private List<Place> places = null;

    public BMDCacheImpl(PersonService personService, PlaceService placeService) {
        this.personService = personService;
        this.placeService = placeService;
    }

    @Override
    public List<Person> getPeople() {
        if (people == null) {
            people = personService.findAll();
        }
        return people;
    }

    @Override
    public void invalidatePeople() {
         people = null;
    }

    @Override
    public List<Place> getPlaces() {
        if (places == null) {
            places = placeService.findAll();
        }
        return places;
    }

    @Override
    public void invalidatePlaces() {
        places = null;
    }
}
