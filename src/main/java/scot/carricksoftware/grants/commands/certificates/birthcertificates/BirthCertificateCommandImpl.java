/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.birthcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.general.Sex;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

public class BirthCertificateCommandImpl implements BirthCertificateCommand {

    Long Id;

    Person newBorn;

    private String certificateNumber;

    private Organisation certificateSource;

    private String certificateDate;

    private CertificateType certificateType;

    private Organisation registrationAuthority;

    private String volume;

    private String number;

    private String whenBorn;

    private String whereBorn;

    private Sex sex;


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
    public Organisation getRegistrationAuthority() {
        return registrationAuthority;
    }

    @Override
    public void setRegistrationAuthority(Organisation registrationAuthority) {
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

    @Override
    public String getWhenBorn() {
        return whenBorn;
    }

    @Override
    public void setWhenBorn(String whenBorn) {
        this.whenBorn = whenBorn;
    }

    @Override
    public String getWhereBorn() {
        return whereBorn;
    }

    @Override
    public void setWhereBorn(String whereBorn) {
        this.whereBorn = whereBorn;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
