/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateGroomCommandConverterImpl implements MarriageCertificateGroomCommandConverter {

    @Override
    public void convert(MarriageCertificateCommand source, MarriageCertificate target) {
        target.setGroomUsualResidence(source.getGroomUsualResidence());
        target.setGroomUntrackedResidence(source.getGroomUntrackedResidence());
        target.setGroomUntrackedFather(source.getGroomUntrackedFather());
        target.setGroomRank(source.getGroomRank());
        target.setGroomFatherRank(source.getGroomFatherRank());
        target.setGroomFather(source.getGroomFather());
        target.setGroomCondition(source.getGroomCondition());
        target.setGroomAge(source.getGroomAge());
        target.setGroom(source.getGroom());
    }
}
