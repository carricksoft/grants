/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.MarriageCertificateBrideCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.MarriageCertificateGroomCommandConverter;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateCommandConverterImpl implements MarriageCertificateCommandConverter {

    private final MarriageCertificateBrideCommandConverter brideConverter;
    private final MarriageCertificateGroomCommandConverter groomConverter;

    public MarriageCertificateCommandConverterImpl(MarriageCertificateBrideCommandConverter brideConverter, MarriageCertificateGroomCommandConverter groomConverter) {
        this.brideConverter = brideConverter;
        this.groomConverter = groomConverter;
    }

    @Override
    public MarriageCertificate convert(MarriageCertificateCommand source) {
        MarriageCertificate target = new MarriageCertificate();
        brideConverter.convert(source, target);
        groomConverter.convert(source, target);

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
