/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateBrideCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateCertificateCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateGroomCommandConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command.MarriageCertificateWitnessCommandConverter;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateCommandConverterImpl implements MarriageCertificateCommandConverter {

    private final MarriageCertificateBrideCommandConverter brideConverter;
    private final MarriageCertificateGroomCommandConverter groomConverter;
    private final MarriageCertificateWitnessCommandConverter witnessConverter;
    private final MarriageCertificateCertificateCommandConverter certificateConverter;

    public MarriageCertificateCommandConverterImpl(MarriageCertificateBrideCommandConverter brideConverter,
                                                   MarriageCertificateGroomCommandConverter groomConverter,
                                                   MarriageCertificateWitnessCommandConverter witnessConverter,
                                                   MarriageCertificateCertificateCommandConverter certificateConverter) {
        this.brideConverter = brideConverter;
        this.groomConverter = groomConverter;
        this.witnessConverter = witnessConverter;
        this.certificateConverter = certificateConverter;
    }

    @Override
    public MarriageCertificate convert(MarriageCertificateCommand source) {
        MarriageCertificate target = new MarriageCertificate();
        brideConverter.convert(source, target);
        groomConverter.convert(source, target);
        witnessConverter.convert(source, target);
        certificateConverter.convert(source, target);

        return target;
    }
}
