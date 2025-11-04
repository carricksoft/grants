/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.places;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import scot.carricksoftware.grants.BaseEntity;

@Entity(name="`organisation`")
public class Organisation extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`name`")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
