/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.birthcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;

public class BirthCertificateCommandImpl implements BirthCertificateCommand {

    Long Id;

    Person newBorn;

    private String certificateNumber;

    private Place certificateIssuedAt;

    private String certificateDate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getNewBorn() {
        return this.newBorn;
    }

    @Override
    public void setNewBorn(Person newBorn) {
        this.newBorn = newBorn;
    }

    @Override
    public String getCertificateNumber() {
        return certificateNumber;
    }

    @Override
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @Override
    public Place getCertificateIssuedAt() {
        return certificateIssuedAt;
    }

    @Override
    public void setCertificateIssuedAt(Place certificateIssuedAt) {
        this.certificateIssuedAt = certificateIssuedAt;
    }

    @Override
    public String getCertificateDate() {
        return certificateDate;
    }

    @Override
    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }
}
