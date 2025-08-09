/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.certificates.marriagecertificates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;

@Component
public class CapitaliseMarriageCertificateImpl implements CapitaliseMarriageCertificate {

    private static final Logger logger = LogManager.getLogger(CapitaliseMarriageCertificateImpl.class);

    private final CapitaliseString capitaliseString;

    public CapitaliseMarriageCertificateImpl(CapitaliseString capitaliseString) {
        this.capitaliseString = capitaliseString;
    }

    @Override
    public void capitalise(MarriageCertificateCommand marriageCertificateCommand) {
        logger.debug("CapitaliseMarriageCertificate::capitalise");
        marriageCertificateCommand.setCertificateNumber(capitaliseString.capitalise(marriageCertificateCommand.getCertificateNumber()));
        marriageCertificateCommand.setVolume(capitaliseString.capitalise(marriageCertificateCommand.getVolume()));
        marriageCertificateCommand.setNumber(capitaliseString.capitalise(marriageCertificateCommand.getNumber()));
        marriageCertificateCommand.setUntrackedWhereMarried(capitaliseString.capitalise(marriageCertificateCommand.getUntrackedWhereMarried()));
        marriageCertificateCommand.setGroomUntrackedResidence(capitaliseString.capitalise(marriageCertificateCommand.getGroomUntrackedResidence()));
        marriageCertificateCommand.setBrideUntrackedResidence(capitaliseString.capitalise(marriageCertificateCommand.getBrideUntrackedResidence()));
        marriageCertificateCommand.setGroomUntrackedFather(capitaliseString.capitalise(marriageCertificateCommand.getGroomUntrackedFather()));
        marriageCertificateCommand.setBrideUntrackedFather(capitaliseString.capitalise(marriageCertificateCommand.getBrideUntrackedFather()));
        marriageCertificateCommand.setUntrackedFirstWitness(capitaliseString.capitalise(marriageCertificateCommand.getUntrackedFirstWitness()));
        marriageCertificateCommand.setUntrackedSecondWitness(capitaliseString.capitalise(marriageCertificateCommand.getUntrackedSecondWitness()));
        marriageCertificateCommand.setBrideRank(capitaliseString.capitalise(marriageCertificateCommand.getBrideRank()));
        marriageCertificateCommand.setGroomRank(capitaliseString.capitalise(marriageCertificateCommand.getGroomRank()));
        marriageCertificateCommand.setGroomFatherRank(capitaliseString.capitalise(marriageCertificateCommand.getGroomFatherRank()));
        marriageCertificateCommand.setBrideFatherRank(capitaliseString.capitalise(marriageCertificateCommand.getBrideFatherRank()));
    }

}
