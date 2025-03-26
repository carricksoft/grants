/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import scot.carricksoftware.grants.domains.people.Person;

public interface BirthCertificateCommand {


    Long getId();

    void setId(Long id);

    Person getPerson();

    void setPerson(Person person);
}
