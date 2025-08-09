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

        target.setBrideUsualResidence(source.getBrideUsualResidence());
        target.setBrideUntrackedResidence(source.getBrideUntrackedResidence());
        target.setBrideUntrackedFather(source.getBrideUntrackedFather());
        target.setBrideRank(source.getBrideRank());
        target.setBrideFatherRank(source.getBrideFatherRank());
        target.setBrideFather(source.getBrideFather());
        target.setBrideCondition(source.getBrideCondition());
        target.setBrideAge(source.getBrideAge());
        target.setBride(source.getBride());

    }
}
