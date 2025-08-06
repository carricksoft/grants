/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateCommandConverterImpl implements MarriageCertificateCommandConverter {

    @Override
    public MarriageCertificate convert(MarriageCertificateCommand source) {
        MarriageCertificate target = new MarriageCertificate();

        target.setGroomUsualResidence(source.getGroomUsualResidence());
        target.setBrideUsualResidence(source.getBrideUsualResidence());
        target.setGroomUntrackedResidence(source.getGroomUntrackedResidence());
        target.setBrideUntrackedResidence(source.getBrideUntrackedResidence());
        target.setGroomFather(source.getGroomFather());
        target.setBrideFather(source.getBrideFather());
        target.setGroomUntrackedFather(source.getGroomUntrackedFather());
        target.setBrideUntrackedFather(source.getBrideUntrackedFather());
        target.setBrideFatherRank(source.getBrideFatherRank());
        target.setFirstWitness(source.getFirstWitness());
        target.setSecondWitness(source.getSecondWitness());
        target.setUntrackedFirstWitness(source.getUntrackedFirstWitness());
        target.setUntrackedSecondWitness(source.getUntrackedSecondWitness());
        target.setId(source.getId());
        target.setBride(source.getBride());
        target.setGroom(source.getGroom());
        target.setWhenMarried(source.getWhenMarried());
        target.setWhereMarried(source.getWhereMarried());
        target.setUntrackedWhereMarried(source.getUntrackedWhereMarried());
        target.setGroomAge(source.getGroomAge());
        target.setBrideAge(source.getBrideAge());
        target.setGroomCondition(source.getGroomCondition());
        target.setBrideCondition(source.getBrideCondition());
        target.setGroomRank(source.getGroomRank());
        target.setBrideRank(source.getBrideRank());

        target.setCertificateNumber(source.getCertificateNumber());
        target.setCertificateType(source.getCertificateType());
        target.setCertificateSource(source.getCertificateSource());
        target.setCertificateDate(source.getCertificateDate());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setVolume(source.getVolume());
        target.setNumber(source.getNumber());

        return target;
    }
}
