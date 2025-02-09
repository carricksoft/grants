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

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Person findById(Long aLong) {
        logger.debug("PersonServiceImpl::findById");
        throw new UnsupportedOperationException();
    }

    @Override
    public Person findAll() {
        logger.debug("PersonServiceImpl::findAll");
        throw new UnsupportedOperationException();
    }

    @Override
    public Person save(Person person) {
        logger.debug("PersonServiceImpl::save");
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Person object) {
        logger.debug("PersonServiceImpl::delete");
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Person> getPagedPersons(int pageNumber) {
        logger.debug("PersonServiceImpl::getPagedPersons");
        throw new UnsupportedOperationException();
    }
}
