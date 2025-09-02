/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.deathcertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.converters.people.PersonConverter;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.services.people.PersonService;

import static java.util.Objects.isNull;

@Component
public class UpdateCertifiedYearOfDeathImpl implements UpdateCertifiedYearOfDeath {

    private static final Logger logger = LogManager.getLogger(UpdateCertifiedYearOfDeathImpl.class);
    private final PersonService personService;
    private final PersonConverter personConverter;

    public UpdateCertifiedYearOfDeathImpl(PersonConverter personConverter,
                                          PersonService personService) {
        this.personService = personService;
        this.personConverter = personConverter;
    }


    @Override
    public void updateCertifiedYearOfDeath(DeathCertificateCommand deathCertificateCommand) {
        logger.debug("UpdateCertifiedYearOfBirthImpl::updateRecordedYearOfBirth");
        Person person = deathCertificateCommand.getDeceased();
        if (!isNull(person)) {
           String certifiedYearOfDeath = getYearOfDeath(deathCertificateCommand.getWhenDied());
           updateDate(person, certifiedYearOfDeath);
        }
    }

    private String getYearOfDeath(String whenDied) {
        logger.debug("UpdateRecordedYearOfBirthImpl::GetYearOfBirth");
        return whenDied.substring(6, 10);
    }

    private void updateDate(Person person,
                            String certifiedYearOfDeath) {
        logger.debug("UpdateRecordedYearOfDeathImpl::UpdateDate");
        PersonCommand personCommand = personConverter.convert(person);
        if (personCommand != null) {
            personCommand.setCertifiedYearOfDeath(certifiedYearOfDeath);
            personService.savePersonCommand(personCommand);
        } else {
            logNoCommandError();
        }
    }

    private void logNoCommandError() {
        logger.debug("PersonCommand = null.");
    }

}
