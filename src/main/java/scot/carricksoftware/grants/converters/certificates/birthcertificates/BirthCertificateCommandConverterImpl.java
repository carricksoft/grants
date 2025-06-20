/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

@Component
public class BirthCertificateCommandConverterImpl implements BirthCertificateCommandConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public BirthCertificate convert(BirthCertificateCommand source) {
        BirthCertificate target = new BirthCertificate();

        target.setId(source.getId());
        target.setNewBorn(source.getNewBorn());
        target.setCertificateNumber(source.getCertificateNumber());
        target.setCertificateDate(source.getCertificateDate());
        target.setCertificateSource(source.getCertificateSource());
        target.setCertificateType(source.getCertificateType());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setVolume(source.getVolume());
        target.setNumber(source.getNumber());
        target.setSex(source.getSex());
        target.setWhenBorn(source.getWhenBorn());
        target.setWhereBorn(source.getWhereBorn());
        target.setUntrackedWhereBorn(source.getUntrackedWhereBorn());
        target.setFather(source.getFather());
        target.setUntrackedFather(source.getUntrackedFather());
        target.setFatherRank(source.getFatherRank());
        target.setMother(source.getMother());
        target.setDateAndPlaceOfMarriage(source.getDateAndPlaceOfMarriage());
        target.setInformant(source.getInformant());
        target.setUntrackedInformant(source.getUntrackedInformant());
        target.setInformantQualification(source.getInformantQualification());


        return target;
    }
}
