/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import scot.carricksoftware.grants.BaseEntity;

import java.util.Set;


@Entity
public class Country extends BaseEntity {
    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToMany
    @JoinColumn(name = "country_id")
    private Set<Place> places;

    public Country() {
        //
        // empty constructor required by JPA
        //
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public Set<Place> getPlaces() {
        return places;
    }

    @SuppressWarnings("unused")
    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
}
