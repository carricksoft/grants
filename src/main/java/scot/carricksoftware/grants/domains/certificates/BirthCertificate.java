/*
 * Copyright (c)  28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.certificates;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.people.Person;

@Entity
public class BirthCertificate extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
