/*
 * Copyright (c)  21 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.census;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Place;

@Component
public class CensusCommand {
    Long id;
    Place place;

    @DateTimeFormat(pattern = "dd MMM yyyy")
    String date;

    public CensusCommand() {
        // Required by JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
