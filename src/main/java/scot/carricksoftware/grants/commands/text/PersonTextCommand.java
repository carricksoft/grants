/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:42. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import scot.carricksoftware.grants.domains.people.Person;

public interface
PersonTextCommand {
    Long getId();

    void setId(Long id);

    Person getPerson();

    void setPerson(Person person);
}
