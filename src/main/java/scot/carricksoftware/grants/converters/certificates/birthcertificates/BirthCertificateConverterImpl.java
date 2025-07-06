/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

@SuppressWarnings("unused")

@Component
public class BirthCertificateConverterImpl implements BirthCertificateConverter {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public BirthCertificateCommand convert(BirthCertificate source) {
        BirthCertificateCommand target = new BirthCertificateCommandImpl();

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
        target.setWhenRegistered(source.getWhenRegistered());
        target.setWhereRegistered(source.getWhereRegistered());
        target.setUntrackedFatherUsualResidence(source.getUntrackedFatherUsualResidence());
        target.setFatherUsualResidence(source.getFatherUsualResidence());
        target.setUntrackedMotherUsualResidence(source.getUntrackedMotherUsualResidence());
        target.setMotherUsualResidence(source.getMotherUsualResidence());
        target.setInformantResidence(source.getInformantResidence());
        target.setMotherPlaceOfBirth(source.getMotherPlaceOfBirth());
        target.setFatherPlaceOfBirth(source.getFatherPlaceOfBirth());

        return target;
    }
}
