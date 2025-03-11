/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class Place extends BaseEntity {

    private String name;

    @OneToOne
    private Region region;

    @SuppressWarnings("unused")
    public Region getRegion() {
        return region;
    }

    @SuppressWarnings("unused")
    public void setRegion(Region region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
