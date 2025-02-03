/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class Place extends BaseEntity {

    private String name;
    @ManyToOne
    private Country country;

    @ManyToOne
    private Region region;


    public Place() {
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
    public Country getCountry() {
        return country;
    }

    @SuppressWarnings("unused")
    public void setCountry(Country country) {
        this.country = country;
    }

    @SuppressWarnings("unused")
    public Region getRegion() {
        return region;
    }

    @SuppressWarnings("unused")
    public void setRegion(Region region) {
        this.region = region;
    }
}
