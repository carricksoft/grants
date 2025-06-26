/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.birthcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;

@Component
public class CapitaliseBirthCertificateImpl implements CapitaliseBirthCertificate {

    private static final Logger logger = LogManager.getLogger(CapitaliseBirthCertificateImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseBirthCertificateImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }


    @Override
    public void capitalise(BirthCertificateCommand birthCertificateCommand) {
        logger.debug("CapitaliseBirthCertificate::capitalise");
        birthCertificateCommand.setInformantQualification(capitaliseString.capitalise(birthCertificateCommand.getInformantQualification()));
        birthCertificateCommand.setUntrackedWhereBorn(capitaliseString.capitalise(birthCertificateCommand.getUntrackedWhereBorn()));
        birthCertificateCommand.setUntrackedFather(capitaliseString.capitalise(birthCertificateCommand.getUntrackedFather()));
        birthCertificateCommand.setUntrackedInformant(capitaliseString.capitalise(birthCertificateCommand.getUntrackedInformant()));
        birthCertificateCommand.setWhenBorn(capitaliseString.capitalise(birthCertificateCommand.getWhenBorn()));
        birthCertificateCommand.setCertificateNumber(capitaliseString.capitalise(birthCertificateCommand.getCertificateNumber()));
        birthCertificateCommand.setWhereRegistered(capitaliseString.capitalise(birthCertificateCommand.getWhereRegistered()));
    }

}
