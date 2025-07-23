/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.deathcertificates;


import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;

public interface UpdateCertifiedYearOfDeath {

    void updateCertifiedYearOfDeath(DeathCertificateCommand deathCertificateCommand);
}
