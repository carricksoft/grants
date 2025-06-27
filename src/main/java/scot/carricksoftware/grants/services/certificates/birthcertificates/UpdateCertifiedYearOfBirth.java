/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.birthcertificates;

import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;

public interface UpdateCertifiedYearOfBirth {

    void updateCertifiedYearOfBirth(BirthCertificateCommand birthCertificateCommand);
}
