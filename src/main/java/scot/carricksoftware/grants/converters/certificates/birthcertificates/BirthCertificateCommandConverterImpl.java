/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

@Component
public class BirthCertificateCommandConverterImpl implements BirthCertificateCommandConverter {

    @Override
    public BirthCertificate convert(@NotNull BirthCertificateCommand source) {
        BirthCertificate target = new BirthCertificate();
        target.setId(source.getId());
        target.setPerson(source.getPerson());
        return target;
    }

}
