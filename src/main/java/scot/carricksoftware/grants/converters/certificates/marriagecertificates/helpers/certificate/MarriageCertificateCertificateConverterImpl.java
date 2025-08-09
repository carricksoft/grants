/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.certificate;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateCertificateConverterImpl implements MarriageCertificateCertificateConverter {

    @Override
    public void convert(MarriageCertificate source, MarriageCertificateCommand target) {

        target.setId(source.getId());
        target.setCertificateNumber(source.getCertificateNumber());
        target.setCertificateDate(source.getCertificateDate());
        target.setCertificateType(source.getCertificateType());
        target.setCertificateSource(source.getCertificateSource());
        target.setNumber(source.getNumber());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setUntrackedWhereMarried(source.getUntrackedWhereMarried());
        target.setVolume(source.getVolume());
        target.setWhenMarried(source.getWhenMarried());
        target.setWhereMarried(source.getWhereMarried());
    }
}
