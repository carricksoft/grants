/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;


@Component
public class DeathCertificateMilitaryConverterImpl implements DeathCertificateMilitaryConverter {

    @Override
    public void convert(DeathCertificate source, DeathCertificateCommand target) {
        target.setRegiment(source.getRegiment());
        target.setServiceNumber(source.getServiceNumber());
        target.setServiceRank(source.getServiceRank());
    }
}
