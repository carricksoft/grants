/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.certificates.divorcecertificates;

import org.springframework.core.convert.converter.Converter;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;

public interface DivorceCertificateCommandConverter extends Converter<DivorceCertificateCommand, DivorceCertificate> {

    @Override
    DivorceCertificate convert(@SuppressWarnings("NullableProblems") DivorceCertificateCommand source);

}
