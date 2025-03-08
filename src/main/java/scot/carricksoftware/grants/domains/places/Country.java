/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import scot.carricksoftware.grants.BaseEntity;

import java.util.Set;

@Entity
public class Country extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Region> regions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
