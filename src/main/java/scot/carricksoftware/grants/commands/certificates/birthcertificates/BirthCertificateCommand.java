/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.birthcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;

import java.sql.Date;

public interface BirthCertificateCommand {


    Long getId();

    void setId(Long id);

    Person getNewBorn();

    void setNewBorn(Person newBorn);

    @SuppressWarnings("unused")
    String getCertificateNumber();

    @SuppressWarnings("unused")
    void setCertificateNumber(String certificateNumber);

    @SuppressWarnings("unused")
    Place getCertificateIssuedAt();

    @SuppressWarnings("unused")
    void setCertificateIssuedAt(Place certificateIssuedAt);

    @SuppressWarnings("unused")
    Date getCertificateDate();

    @SuppressWarnings("unused")
    void setCertificateDate(Date certificateDate);
}
