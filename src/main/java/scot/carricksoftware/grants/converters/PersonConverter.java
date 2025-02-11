/*
 * Copyright (c)  11 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters;


import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

public class PersonConverter implements Converter<Person, PersonCommand> {

    @Override
    public PersonCommand convert(Person source) {
        PersonCommand command = new PersonCommand();
        command.setId(source.getId());
        command.setFirstName(source.getFirstName());
        command.setLastName(source.getLastName());
        return command;
    }
}
