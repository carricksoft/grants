/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;


import jakarta.persistence.*;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class Place extends BaseEntity {

    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "place_region_id")
    private Region region;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
