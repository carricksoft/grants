/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.people;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {


    @Id
    private Long id;

    @SuppressWarnings("unused")
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
