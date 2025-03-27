/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.birthcertificates;

import scot.carricksoftware.grants.domains.people.Person;

public class BirthCertificateCommandImpl implements BirthCertificateCommand {

    Long Id;

    Person person;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }
}
