/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);


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
        logger.debug("PersonServiceImpl::save");
        return personRepository.save(person);
    }

    @Override
    public void delete(Person object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }
}
