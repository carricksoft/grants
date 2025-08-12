/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.services.certificates.marriagecertificates.helpers;

import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;

import java.time.LocalDate;

public class SetYearMarriedImpl implements SetYearMarried {

    @Override
    // consider dd/mm/yyyy
    public void setDatesMarried(MarriageCertificateCommand marriageCertificatecommand) {
        try {
            LocalDate.parse(marriageCertificatecommand.getWhenMarried(), ApplicationConstants.FORMATTER);
            marriageCertificatecommand.setYearMarried(marriageCertificatecommand.getWhenMarried().substring(6,10));
            marriageCertificatecommand.setMonthMarried(marriageCertificatecommand.getWhenMarried().substring(3,5));
            marriageCertificatecommand.setDayMarried(marriageCertificatecommand.getWhenMarried().substring(0,2));

        } catch (Exception e) {
            marriageCertificatecommand.setYearMarried(null);
            marriageCertificatecommand.setMonthMarried(null);
            marriageCertificatecommand.setDayMarried(null);
        }
    }
}
