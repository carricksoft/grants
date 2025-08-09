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

    private final MarriageCertificateBrideCommandConverter brideConverter;

    public MarriageCertificateCommandConverterImpl(MarriageCertificateBrideCommandConverter brideConverter) {
        this.brideConverter = brideConverter;
    }

    @Override
    public MarriageCertificate convert(MarriageCertificateCommand source) {
        MarriageCertificate target = new MarriageCertificate();
        brideConverter.convert(source, target);

        target.setBride(source.getBride());
        target.setBrideAge(source.getBrideAge());
        target.setBrideCondition(source.getBrideCondition());
        target.setBrideFather(source.getBrideFather());
        target.setBrideFatherRank(source.getBrideFatherRank());
        target.setBrideRank(source.getBrideRank());
        target.setBrideUntrackedFather(source.getBrideUntrackedFather());
        target.setBrideUntrackedResidence(source.getBrideUntrackedResidence());
        target.setBrideUsualResidence(source.getBrideUsualResidence());
        target.setCertificateDate(source.getCertificateDate());
        target.setCertificateNumber(source.getCertificateNumber());
        target.setCertificateSource(source.getCertificateSource());
        target.setCertificateType(source.getCertificateType());
        target.setFirstWitness(source.getFirstWitness());
        target.setGroom(source.getGroom());
        target.setGroomAge(source.getGroomAge());
        target.setGroomCondition(source.getGroomCondition());
        target.setGroomFather(source.getGroomFather());
        target.setGroomFatherRank(source.getGroomFatherRank());
        target.setGroomRank(source.getGroomRank());
        target.setGroomUntrackedFather(source.getGroomUntrackedFather());
        target.setGroomUntrackedResidence(source.getGroomUntrackedResidence());
        target.setGroomUsualResidence(source.getGroomUsualResidence());
        target.setId(source.getId());
        target.setNumber(source.getNumber());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setSecondWitness(source.getSecondWitness());
        target.setUntrackedFirstWitness(source.getUntrackedFirstWitness());
        target.setUntrackedSecondWitness(source.getUntrackedSecondWitness());
        target.setUntrackedWhereMarried(source.getUntrackedWhereMarried());
        target.setVolume(source.getVolume());
        target.setWhenMarried(source.getWhenMarried());
        target.setWhereMarried(source.getWhereMarried());

        return target;
    }
}
