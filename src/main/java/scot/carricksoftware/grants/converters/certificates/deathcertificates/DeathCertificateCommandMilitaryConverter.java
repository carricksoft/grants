/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

public interface DeathCertificateCommandMilitaryConverter {

    void convert(DeathCertificateCommand source, DeathCertificate target);
}
