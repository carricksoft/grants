/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

@SuppressWarnings("unused")
@Component
public class DeathCertificateCommandConverterImpl implements DeathCertificateCommandConverter {

    @Override
    public DeathCertificate convert(DeathCertificateCommand source) {

        DeathCertificate target = new DeathCertificate();

        target.setId(source.getId());target.setCertificateNumber(source.getCertificateNumber());
        target.setCertificateDate(source.getCertificateDate());
        target.setCertificateSource(source.getCertificateSource());
        target.setCertificateType(source.getCertificateType());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setVolume(source.getVolume());
        target.setNumber(source.getNumber());
        target.setDeceased(source.getDeceased());
        target.setFather(source.getFather());
        target.setInformant(source.getInformant());
        target.setMother(source.getMother());
        target.setSpouse(source.getSpouse());
        target.setUsualResidence(source.getUsualResidence());
        target.setWhereDied(source.getWhereDied());
        target.setSex(source.getSex());
        target.setAge(source.getAge());
        target.setCauseOfDeath(source.getCauseOfDeath());
        target.setFatherOccupation(source.getFatherOccupation());
        target.setInformantAddress(source.getInformantAddress());
        target.setInformantQualification(source.getInformantQualification());
        target.setMaritalStatus(source.getMaritalStatus());
        target.setMotherOccupation(source.getMotherOccupation());
        target.setOccupation(source.getOccupation());
        target.setSpouseOccupation(source.getSpouseOccupation());
        target.setUntrackedFather(source.getUntrackedFather());
        target.setUntrackedInformant(source.getUntrackedInformant());
        target.setUntrackedMother(source.getUntrackedMother());
        target.setUntrackedSpouse(source.getUntrackedSpouse());
        target.setUntrackedUsualResidence(source.getUntrackedUsualResidence());
        target.setUntrackedWhereDied(source.getUntrackedWhereDied());
        target.setWhenBorn(source.getWhenBorn());
        target.setWhenDied(source.getWhenDied());
        target.setWhenRegistered(source.getWhenRegistered());
        target.setWhereRegistered(source.getWhereRegistered());

        return target;
    }
}
