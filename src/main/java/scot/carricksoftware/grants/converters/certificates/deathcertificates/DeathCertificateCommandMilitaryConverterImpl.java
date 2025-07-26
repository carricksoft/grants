/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

@CommandLine.Command
public class DeathCertificateCommandMilitaryConverterImpl implements DeathCertificateCommandMilitaryConverter {

    @Override
    public void convert(DeathCertificateCommand source, DeathCertificate target) {
        target.setRegiment(source.getRegiment());
        target.setServiceNumber(source.getServiceNumber());
        target.setServiceRank(source.getServiceRank());
    }
}
