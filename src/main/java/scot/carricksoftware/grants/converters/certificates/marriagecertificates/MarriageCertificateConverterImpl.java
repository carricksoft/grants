/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateBrideConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateCertificateConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateDateConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateGroomConverter;
import scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate.MarriageCertificateWitnessConverter;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@SuppressWarnings("unused")

@Component
public class MarriageCertificateConverterImpl implements MarriageCertificateConverter {

    private final MarriageCertificateBrideConverter brideConverter;
    private final MarriageCertificateGroomConverter groomConverter;
    private final MarriageCertificateWitnessConverter witnessConverter;
    private final MarriageCertificateCertificateConverter certificateConverter;
    private final MarriageCertificateDateConverter dateConverter;


    public MarriageCertificateConverterImpl(MarriageCertificateBrideConverter brideConverter,
                                            MarriageCertificateGroomConverter groomConverter,
                                            MarriageCertificateWitnessConverter witnessConverter,
                                            MarriageCertificateCertificateConverter certificateConverter,
                                            MarriageCertificateDateConverter dateConverter) {
        this.brideConverter = brideConverter;
        this.groomConverter = groomConverter;
        this.witnessConverter = witnessConverter;
        this.certificateConverter = certificateConverter;
        this.dateConverter = dateConverter;
    }

    @Override
    public MarriageCertificateCommand convert(MarriageCertificate source) {
        MarriageCertificateCommand target = new MarriageCertificateCommandImpl();
        brideConverter.convert(source, target);
        groomConverter.convert(source, target);
        witnessConverter.convert(source, target);
        certificateConverter.convert(source, target);
        dateConverter.convert(source, target);

        return target;
    }
}
