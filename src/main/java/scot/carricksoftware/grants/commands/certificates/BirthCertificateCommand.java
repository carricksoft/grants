/*
 * Copyright (c)  28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.certificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class BirthCertificateCommand {

    Long id;
    Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
