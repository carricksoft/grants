/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.deathcertificate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;

@Component
public class CapitaliseDeathCertificateImpl implements CapitaliseDeathCertificate {

    private static final Logger logger = LogManager.getLogger(CapitaliseDeathCertificateImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseDeathCertificateImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(DeathCertificateCommand birthCertificateCommand) {
        logger.debug("CapitaliseBirthCertificate::capitalise");
        birthCertificateCommand.setInformantQualification(capitaliseString.capitalise(birthCertificateCommand.getInformantQualification()));
        birthCertificateCommand.setUntrackedWhereDied(capitaliseString.capitalise(birthCertificateCommand.getUntrackedWhereDied()));
        birthCertificateCommand.setUntrackedFather(capitaliseString.capitalise(birthCertificateCommand.getUntrackedFather()));
        birthCertificateCommand.setUntrackedMother(capitaliseString.capitalise(birthCertificateCommand.getUntrackedMother()));
        birthCertificateCommand.setUntrackedInformant(capitaliseString.capitalise(birthCertificateCommand.getUntrackedInformant()));
        birthCertificateCommand.setWhenBorn(capitaliseString.capitalise(birthCertificateCommand.getWhenBorn()));
        birthCertificateCommand.setCertificateNumber(capitaliseString.capitalise(birthCertificateCommand.getCertificateNumber()));
        birthCertificateCommand.setWhereRegistered(capitaliseString.capitalise(birthCertificateCommand.getWhereRegistered()));
        birthCertificateCommand.setOccupation(capitaliseString.capitalise(birthCertificateCommand.getOccupation()));
        birthCertificateCommand.setUntrackedUsualResidence(capitaliseString.capitalise(birthCertificateCommand.getUntrackedUsualResidence()));
        birthCertificateCommand.setSpouseOccupation(capitaliseString.capitalise(birthCertificateCommand.getSpouseOccupation()));
        birthCertificateCommand.setFatherOccupation(capitaliseString.capitalise(birthCertificateCommand.getFatherOccupation()));
        birthCertificateCommand.setMotherOccupation(capitaliseString.capitalise(birthCertificateCommand.getMotherOccupation()));
    }

}
