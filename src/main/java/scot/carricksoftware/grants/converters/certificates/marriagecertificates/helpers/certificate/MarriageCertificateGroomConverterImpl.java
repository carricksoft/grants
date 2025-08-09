/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateGroomConverterImpl implements MarriageCertificateGroomConverter {

    @Override
    public void convert(MarriageCertificate source, MarriageCertificateCommand target) {
        target.setGroom(source.getGroom());
        target.setGroomAge(source.getGroomAge());
        target.setGroomCondition(source.getGroomCondition());
        target.setGroomFather(source.getGroomFather());
        target.setGroomFatherRank(source.getGroomFatherRank());
        target.setGroomRank(source.getGroomRank());
        target.setGroomUntrackedFather(source.getGroomUntrackedFather());
        target.setGroomUntrackedResidence(source.getGroomUntrackedResidence());
        target.setGroomUsualResidence(source.getGroomUsualResidence());
    }
}
