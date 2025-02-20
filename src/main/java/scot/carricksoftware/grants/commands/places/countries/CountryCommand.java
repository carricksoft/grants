/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.countries;

import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.Set;

@Component
public class CountryCommand {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters.")
    private String name;

    private Set<Place> places;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
}
