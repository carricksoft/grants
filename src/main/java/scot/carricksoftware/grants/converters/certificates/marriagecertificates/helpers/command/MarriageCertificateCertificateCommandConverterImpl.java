/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateCertificateCommandConverterImpl implements MarriageCertificateCertificateCommandConverter {

    @Override
    public void convert(MarriageCertificateCommand source, MarriageCertificate target) {

        target.setWhereMarried(source.getWhereMarried());
        target.setCertificateSource(source.getCertificateSource());
        target.setCertificateNumber(source.getCertificateNumber());
        target.setCertificateDate(source.getCertificateDate());
        target.setCertificateType(source.getCertificateType());
        target.setWhenMarried(source.getWhenMarried());
        target.setVolume(source.getVolume());
        target.setUntrackedWhereMarried(source.getUntrackedWhereMarried());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setNumber(source.getNumber());
        target.setId(source.getId());
    }
}
