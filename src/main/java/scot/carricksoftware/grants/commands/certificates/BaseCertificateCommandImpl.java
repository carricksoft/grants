/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates;


import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Place;

import java.sql.Date;

@Component
public class BaseCertificateCommandImpl implements BaseCertificateCommand {

    private String certificateNumber;

    private Place certificateIssuedAt;

    private Date certificateDate;


    @Override
    public String getCertificateNumber() {
        return certificateNumber;
    }

    @Override
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @Override
    public Date getCertificateDate() {
        return certificateDate;
    }

    @Override
    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Override
    public Place getCertificateIssuedAt() {
        return certificateIssuedAt;
    }

    @Override
    public void setCertificateIssuedAt(Place certificateIssuedAt) {
        this.certificateIssuedAt = certificateIssuedAt;
    }

}
