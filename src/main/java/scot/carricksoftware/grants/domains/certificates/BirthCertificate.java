/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.domains.people.Person;

@Entity
public class BirthCertificate extends BaseCertificate {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`new_born_id`")
    private Person newBorn;

    public Person getNewBorn() {
        return newBorn;
    }

    public void setNewBorn(Person newBorn) {
        this.newBorn = newBorn;
    }
}
