/*
 * Copyright (c)  11 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.people;

import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.Set;

@Component
public class RegionCommand {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters.")
    private String name;

    private Set<Place> places;

    public RegionCommand() {
        // required by JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
