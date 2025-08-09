/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.marriagecertificates;

import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

public interface MarriageCertificateBrideCommandConverter {

    void convert(MarriageCertificateCommand source, MarriageCertificate target);

}
