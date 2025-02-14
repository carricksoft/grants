/*
 * Copyright (c)  13 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.people;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class PersonConverterImpl implements Converter<Person, PersonCommand> {

    @Override
    public PersonCommand convert(Person source) {
        PersonCommand target = new PersonCommand();
        target.setId(source.getId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        return target;
    }
}
