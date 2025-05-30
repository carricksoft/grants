/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import scot.carricksoftware.grants.BaseEntity;

@Entity
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
}
