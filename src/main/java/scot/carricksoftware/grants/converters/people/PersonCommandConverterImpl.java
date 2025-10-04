/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:18. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.people;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class PersonCommandConverterImpl implements PersonCommandConverter {

    @Override
    public Person convert(PersonCommand source) {
        Person result = new Person();
        result.setId(source.getId());
        result.setFirstName(source.getFirstName());
        result.setLastName(source.getLastName());
        result.setRecordedYearOfBirth(source.getRecordedYearOfBirth());
        result.setCertifiedYearOfBirth(source.getCertifiedYearOfBirth());
        result.setCertifiedYearOfDeath(source.getCertifiedYearOfDeath());

        result.setCensusEntries(source.getCensusEntries());
        result.setDeathCertificates(source.getDeathCertificates());
        result.setBirthCertificates(source.getBirthCertificates());
        result.setMarriageCertificates(source.getMarriageCertificates());
        result.setDivorceCertificates(source.getDivorceCertificates());
        result.setPersonImages(source.getPersonImages());
        result.setPersonTexts(source.getPersonTexts());
        result.setImage(source.getImage());

        return result;
    }
}
