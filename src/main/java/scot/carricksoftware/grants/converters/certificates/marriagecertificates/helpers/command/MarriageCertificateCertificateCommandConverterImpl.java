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

        target.setId(source.getId());
        target.setNumber(source.getNumber());
        target.setRegistrationAuthority(source.getRegistrationAuthority());
        target.setUntrackedWhereMarried(source.getUntrackedWhereMarried());
        target.setVolume(source.getVolume());
        target.setWhenMarried(source.getWhenMarried());
        target.setWhereMarried(source.getWhereMarried());
    }
}
