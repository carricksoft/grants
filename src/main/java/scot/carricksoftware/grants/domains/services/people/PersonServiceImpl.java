/*
 * Copyright (c) 2025- 03 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.services.people;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Set<Person> findAll() {
        return Set.of();
    }

    @Override
    public Person findById(Long aLong) {
        return null;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Person object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
