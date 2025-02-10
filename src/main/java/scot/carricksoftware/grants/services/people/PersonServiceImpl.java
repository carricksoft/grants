/*
 * Copyright (c) 2025- 04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

    @SuppressWarnings({"unused"})
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
    public Person save(Person person) {
        logger.debug("PersonServiceImpl::save");
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("PersonServiceImpl::deleteBy");
        personRepository.deleteById(id);
    }


    @Override
    public List<Person> getPagedPersons(int pageNumber) {
        logger.debug("PersonServiceImpl::getPagedPersons");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<Person> pagedResult = personRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "lastName");
    }

    @Override
    public long count() {
        logger.debug("PersonServiceImpl::count");
        return personRepository.count();
    }
}
