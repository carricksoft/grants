/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.birthcertificate;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;

@Component
public class CapitaliseBirthCertificateImpl implements CapitaliseBirthCertificate {

   private final CapitaliseString capitaliseString;

    public CapitaliseBirthCertificateImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(BirthCertificateCommand birthCertificateCommand) {
        birthCertificateCommand.setInformantQualification(capitaliseString.capitalise(birthCertificateCommand.getInformantQualification()));
        birthCertificateCommand.setUntrackedWhereBorn(capitaliseString.capitalise(birthCertificateCommand.getUntrackedWhereBorn()));
        birthCertificateCommand.setUntrackedFather(capitaliseString.capitalise(birthCertificateCommand.getUntrackedFather()));
        birthCertificateCommand.setUntrackedInformant(capitaliseString.capitalise(birthCertificateCommand.getUntrackedInformant()));
        birthCertificateCommand.setWhenBorn(capitaliseString.capitalise(birthCertificateCommand.getWhenBorn()));
        birthCertificateCommand.setCertificateNumber(capitaliseString.capitalise(birthCertificateCommand.getCertificateNumber()));
    }



}
