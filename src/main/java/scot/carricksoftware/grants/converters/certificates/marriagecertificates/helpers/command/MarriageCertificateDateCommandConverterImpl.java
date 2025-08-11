/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates.helpers.command;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

@Component
public class MarriageCertificateDateCommandConverterImpl implements MarriageCertificateDateCommandConverter {

    @Override
    public void convert(MarriageCertificateCommand source, MarriageCertificate target) {
        target.setYearMarried(source.getYearMarried());
        target.setMonthMarried(source.getMonthMarried());
        target.setDayMarried(source.getDayMarried());
    }
}
