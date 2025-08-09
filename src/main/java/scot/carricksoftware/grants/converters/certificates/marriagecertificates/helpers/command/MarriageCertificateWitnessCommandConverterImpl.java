/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateWitnessCommandConverterImpl implements MarriageCertificateWitnessCommandConverter {

    @Override
    public void convert(MarriageCertificateCommand source, MarriageCertificate target) {

        target.setFirstWitness(source.getFirstWitness());
        target.setSecondWitness(source.getSecondWitness());
        target.setUntrackedFirstWitness(source.getUntrackedFirstWitness());
        target.setUntrackedSecondWitness(source.getUntrackedSecondWitness());

    }
}
