/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateWitnessConverterImpl implements MarriageCertificateWitnessConverter {

    @Override
    public void convert(MarriageCertificate source, MarriageCertificateCommand target) {

        target.setFirstWitness(source.getFirstWitness());
        target.setSecondWitness(source.getSecondWitness());
        target.setUntrackedFirstWitness(source.getUntrackedFirstWitness());
        target.setUntrackedSecondWitness(source.getUntrackedSecondWitness());

    }
}
