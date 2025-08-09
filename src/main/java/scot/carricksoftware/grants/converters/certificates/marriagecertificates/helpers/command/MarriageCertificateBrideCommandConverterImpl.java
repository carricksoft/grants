/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateBrideCommandConverterImpl implements MarriageCertificateBrideCommandConverter {

    @Override
    public void convert(MarriageCertificateCommand source, MarriageCertificate target) {

        target.setBride(source.getBride());
        target.setBrideAge(source.getBrideAge());
        target.setBrideCondition(source.getBrideCondition());
        target.setBrideFather(source.getBrideFather());
        target.setBrideFatherRank(source.getBrideFatherRank());
        target.setBrideRank(source.getBrideRank());
        target.setBrideUntrackedFather(source.getBrideUntrackedFather());
        target.setBrideUntrackedResidence(source.getBrideUntrackedResidence());
        target.setBrideUsualResidence(source.getBrideUsualResidence());

    }
}
