/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.deathcertificates;

import scot.carricksoftware.grants.commands.certificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.DeathCertificateCommandImpl;

import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

@SuppressWarnings("unused")
public class DeathCertificateConverterImpl implements DeathCertificateConverter {

    @Override
    public DeathCertificateCommand convert(DeathCertificate source) {
        DeathCertificateCommand target = new DeathCertificateCommandImpl();

        target.setId(source.getId());

        return target;
    }
}
