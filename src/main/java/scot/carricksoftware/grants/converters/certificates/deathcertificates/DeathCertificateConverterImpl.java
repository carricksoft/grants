/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;

import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

@SuppressWarnings("unused")
@Component
public class DeathCertificateConverterImpl implements DeathCertificateConverter {

    private final DeathCertificateMilitaryConverter militaryConverter;


    public DeathCertificateConverterImpl(DeathCertificateMilitaryConverter militaryConverter) {
        this.militaryConverter = militaryConverter;
    }

    @Override
    public DeathCertificateCommand convert(DeathCertificate source) {
        DeathCertificateCommand target = new DeathCertificateCommandImpl();

        militaryConverter.convert(source, target);
        target.setAge(source.getAge());
        target.setCauseOfDeath(source.getCauseOfDeath());
        target.setCertificateDate(source.getCertificateDate());
        target.setCertificateNumber(source.getCertificateNumber());
        target.setCertificateSource(source.getCertificateSource());
        target.setCertificateType(source.getCertificateType());
        target.setDeceased(source.getDeceased());
        target.setFather(source.getFather());
        target.setFatherOccupation(source.getFatherOccupation());
        target.setId(source.getId());
        target.setInformant(source.getInformant());
        target.setInformantAddress(source.getInformantAddress());
        target.setInformantQualification(source.getInformantQualification());
        target.setMaritalStatus(source.getMaritalStatus());
        target.setMother(source.getMother());
        target.setMotherOccupation(source.getMotherOccupation());
        target.setNumber(source.getNumber());
        target.setOccupation(source.getOccupation());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setSex(source.getSex());
        target.setSpouse(source.getSpouse());
        target.setSpouseOccupation(source.getSpouseOccupation());
        target.setUntrackedFather(source.getUntrackedFather());
        target.setUntrackedInformant(source.getUntrackedInformant());
        target.setUntrackedMother(source.getUntrackedMother());
        target.setUntrackedSpouse(source.getUntrackedSpouse());
        target.setUntrackedUsualResidence(source.getUntrackedUsualResidence());
        target.setUntrackedWhereDied(source.getUntrackedWhereDied());
        target.setUsualResidence(source.getUsualResidence());
        target.setVolume(source.getVolume());
        target.setWhenBorn(source.getWhenBorn());
        target.setWhenDied(source.getWhenDied());
        target.setWhenRegistered(source.getWhenRegistered());
        target.setWhereDied(source.getWhereDied());
        target.setWhereRegistered(source.getWhereRegistered());

        return target;
    }
}
