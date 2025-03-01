/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomValues.GetRandomPerson;

@Component
public class GenerateCertificateRandomValues {

    @SuppressWarnings("unused")
    public static BirthCertificateCommand GetRandomBirthCertificateCommand() {
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommand();
        birthCertificateCommand.setId(GetRandomLong());
        birthCertificateCommand.setPerson(GetRandomPerson());

        return birthCertificateCommand;
    }

    @SuppressWarnings("unused")
    public static BirthCertificate GetRandomBirthCertificate() {

        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setId(GetRandomLong());
        birthCertificate.setPerson(GetRandomPerson());

        return birthCertificate;
    }
}
