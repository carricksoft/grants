/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class CensusEntry extends BaseEntity {

   private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "censusEntry_census_id")
    private Census census;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
