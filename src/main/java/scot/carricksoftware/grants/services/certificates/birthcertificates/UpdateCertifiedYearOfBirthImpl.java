/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.birthcertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static java.util.Objects.isNull;

@Component
public class UpdateCertifiedYearOfBirthImpl implements UpdateCertifiedYearOfBirth {

    private static final Logger logger = LogManager.getLogger(UpdateCertifiedYearOfBirthImpl.class);
    private final PersonService personService;
    private final PersonConverter personConverter;

    public UpdateCertifiedYearOfBirthImpl(PersonConverter personConverter,
                                          PersonService personService) {
        this.personService = personService;
        this.personConverter = personConverter;
    }


    @Override
    public void updateCertifiedYearOfBirth(BirthCertificateCommand birthCertificateCommand) {
        logger.debug("UpdateCertifiedYearOfBirthImpl::updateRecordedYearOfBirth");
        Person person = birthCertificateCommand.getNewBorn();
        if (!isNull(person)) {
           String certifiedYearOfBirth = getYearOfBirth(birthCertificateCommand.getWhenBorn());
           updateDate(person, certifiedYearOfBirth);
        }
    }

    private String getYearOfBirth(String whenBorn) {
        logger.debug("UpdateRecordedYearOfBirthImpl::GetYearOfBirth");
        return whenBorn.substring(6, 10);
    }

    private void updateDate(Person person,
                            String certifiedYearOfBirth) {
        logger.debug("UpdateRecordedYearOfBirthImpl::UpdateDate");
        PersonCommand personCommand = personConverter.convert(person);
        if (personCommand != null) {
            personCommand.setCertifiedYearOfBirth(certifiedYearOfBirth);
            personService.savePersonCommand(personCommand);
        } else {
            logNoCommandError();
        }
    }

    private void logNoCommandError() {
        logger.info("PersonCommand = null.");
    }



}
