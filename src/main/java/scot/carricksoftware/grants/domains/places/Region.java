/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class Region extends BaseEntity {

    private String name;

    @OneToOne
    private Country country;

    @SuppressWarnings("unused")
    public Country getCountry() {
        return country;
    }

    @SuppressWarnings("unused")
    public void setCountry(Country country) {
        this.country = country;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

}
