/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.birthcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

public class BirthCertificateCommandImpl implements BirthCertificateCommand {

    Long Id;

    Person newBorn;

    private String certificateNumber;

    private Organisation certificateSource;

    private String certificateDate;

    private CertificateType certificateType;

    private Place registrationAuthority;

    private String volume;

    private String number;


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
    public String getCertificateDate() {
        return certificateDate;
    }

    @Override
    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Override
    public Organisation getCertificateSource() {
        return certificateSource;
    }

    @Override
    public void setCertificateSource(Organisation certificateSource) {
        this.certificateSource = certificateSource;
    }

    @Override
    public CertificateType getCertificateType() {
        return certificateType;
    }

    @Override
    public void setCertificateType(CertificateType certificateType) {
        this.certificateType = certificateType;
    }

    @Override
    public Place getRegistrationAuthority() {
        return registrationAuthority;
    }

    @Override
    public void setRegistrationAuthority(Place registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    @Override
    public String getVolume() {
        return volume;
    }

    @Override
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }
}
