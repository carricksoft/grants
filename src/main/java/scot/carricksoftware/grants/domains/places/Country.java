/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import jakarta.persistence.Entity;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class Country extends BaseEntity {
    private String name;

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
}
