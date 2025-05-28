/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import scot.carricksoftware.grants.domains.places.Place;

import java.sql.Date;

public interface BaseCertificateCommand {

    String getCertificateNumber();

    void setCertificateNumber(String certificateNumber);

    Date getCertificateDate();

    void setCertificateDate(Date certificateDate);

    Place getCertificateIssuedAt();

    void setCertificateIssuedAt(Place certificateIssuedAt);
}
