/*
 * Copyright (c)  24 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters.certificates.birthcertificates;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

public interface BirthCertificateConverter extends Converter<BirthCertificate, BirthCertificateCommand> {
    BirthCertificateCommand convert(@org.jetbrains.annotations.NotNull BirthCertificate source);
}
