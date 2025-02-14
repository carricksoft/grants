/*
 * Copyright (c)  13 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.people;


import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

@SuppressWarnings("unused")
public interface PersonCommandConverter extends Converter<PersonCommand, Person> {

    @Override
    Person convert(@NotNull PersonCommand source);


}
