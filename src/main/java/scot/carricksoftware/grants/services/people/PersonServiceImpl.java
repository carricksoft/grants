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
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.people.PersonCommandConverterImpl;
import scot.carricksoftware.grants.converters.people.PersonConverterImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.repositories.people.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final PersonRepository personRepository;
    private final PersonConverterImpl personConverterImpl;
    private final PersonCommandConverterImpl personCommandConverterImpl;

    public PersonServiceImpl(
            PersonRepository personRepository,
            PersonConverterImpl personConverterImpl,
            PersonCommandConverterImpl personCommandConverterImpl) {

        this.personRepository = personRepository;
        this.personConverterImpl = personConverterImpl;
        this.personCommandConverterImpl = personCommandConverterImpl;
    }


    @Override
    public Person findById(Long id) {
        logger.debug("PersonServiceImpl::findById");
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
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

    @Transactional
    @Override
    public PersonCommand savePersonCommand(PersonCommand personCommand) {
        logger.debug("PersonServiceImpl::savePersonCommand");
        Person person = personCommandConverterImpl.convert(personCommand);
        Person savedPerson = personRepository.save(person);
        return personConverterImpl.convert(savedPerson);

    }
}
