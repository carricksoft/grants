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

    private final DeathCertificateCommandMilitaryConverter militaryConverter;

    public DeathCertificateCommandConverterImpl(DeathCertificateCommandMilitaryConverter militaryConverter) {
        this.militaryConverter = militaryConverter;
    }

    @Override
    public DeathCertificate convert(DeathCertificateCommand source) {

        DeathCertificate target = new DeathCertificate();

        militaryConverter.convert(source, target);
        target.setAge(source.getAge());
        target.setSex(source.getSex());
        target.setWhereDied(source.getWhereDied());
        target.setUsualResidence(source.getUsualResidence());
        target.setSpouse(source.getSpouse());
        target.setMother(source.getMother());
        target.setInformant(source.getInformant());
        target.setFather(source.getFather());
        target.setDeceased(source.getDeceased());
        target.setNumber(source.getNumber());
        target.setVolume(source.getVolume());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setCertificateType(source.getCertificateType());
        target.setCertificateSource(source.getCertificateSource());
        target.setCertificateDate(source.getCertificateDate());
        target.setId(source.getId());target.setCertificateNumber(source.getCertificateNumber());
        target.setWhereRegistered(source.getWhereRegistered());
        target.setWhenRegistered(source.getWhenRegistered());
        target.setWhenDied(source.getWhenDied());
        target.setWhenBorn(source.getWhenBorn());
        target.setUntrackedWhereDied(source.getUntrackedWhereDied());
        target.setUntrackedUsualResidence(source.getUntrackedUsualResidence());
        target.setUntrackedSpouse(source.getUntrackedSpouse());
        target.setUntrackedMother(source.getUntrackedMother());
        target.setUntrackedInformant(source.getUntrackedInformant());
        target.setUntrackedFather(source.getUntrackedFather());
        target.setSpouseOccupation(source.getSpouseOccupation());
        target.setOccupation(source.getOccupation());
        target.setMotherOccupation(source.getMotherOccupation());
        target.setMaritalStatus(source.getMaritalStatus());
        target.setInformantQualification(source.getInformantQualification());
        target.setInformantAddress(source.getInformantAddress());
        target.setFatherOccupation(source.getFatherOccupation());
        target.setCauseOfDeath(source.getCauseOfDeath());


        return target;
    }
}
