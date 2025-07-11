/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.birthcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
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

    private Place whereBorn;

    private String untrackedWhereBorn;

    private Sex sex;

    private Person father;

    private String untrackedFather;

    private String fatherRank;

    private Person mother;

    private String dateAndPlaceOfMarriage;

    private Person informant;

    private String untrackedInformant;

    private String informantQualification;

    private String whenRegistered;

    private String whereRegistered;

    private Place fatherUsualResidence;

    private String untrackedFatherUsualResidence;

    private Place motherUsualResidence;

    private String untrackedMotherUsualResidence;

    private String informantResidence;

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
    public Place getWhereBorn() {
        return whereBorn;
    }

    @Override
    public void setWhereBorn(Place whereBorn) {
        this.whereBorn = whereBorn;
    }

    @Override
    public String getUntrackedWhereBorn() {
        return untrackedWhereBorn;
    }

    @Override
    public void setUntrackedWhereBorn(String untrackedWhereBorn) {
        this.untrackedWhereBorn = untrackedWhereBorn;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public Person getFather() {
        return father;
    }

    @Override
    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public String getUntrackedFather() {
        return untrackedFather;
    }

    @Override
    public void setUntrackedFather(String untrackedFather) {
        this.untrackedFather = untrackedFather;
    }

    @Override
    public String getFatherRank() {
        return fatherRank;
    }

    @Override
    public void setFatherRank(String fatherRank) {
        this.fatherRank = fatherRank;
    }

    @Override
    public Person getMother() {
        return mother;
    }

    @Override
    public void setMother(Person mother) {
        this.mother = mother;
    }

    @Override
    public String getDateAndPlaceOfMarriage() {
        return dateAndPlaceOfMarriage;
    }

    @Override
    public void setDateAndPlaceOfMarriage(String dateAndPlaceOfMarriage) {
        this.dateAndPlaceOfMarriage = dateAndPlaceOfMarriage;
    }

    @Override
    public Person getInformant() {
        return informant;
    }

    @Override
    public void setInformant(Person informant) {
        this.informant = informant;
    }

    @Override
    public String getUntrackedInformant() {
        return untrackedInformant;
    }

    @Override
    public void setUntrackedInformant(String untrackedInformant) {
        this.untrackedInformant = untrackedInformant;
    }

    @Override
    public String getInformantQualification() {
        return informantQualification;
    }

    @Override
    public void setInformantQualification(String informantQualification) {
        this.informantQualification = informantQualification;
    }

    @Override
    public String getWhenRegistered() {
        return whenRegistered;
    }

    @Override
    public void setWhenRegistered(String whenRegistered) {
        this.whenRegistered = whenRegistered;
    }

    @Override
    public String getWhereRegistered() {
        return whereRegistered;
    }

    @Override
    public void setWhereRegistered(String whereRegistered) {
        this.whereRegistered = whereRegistered;
    }

    @Override
    public Place getFatherUsualResidence() {
        return fatherUsualResidence;
    }

    @Override
    public void setFatherUsualResidence(Place fatherUsualResidence) {
        this.fatherUsualResidence = fatherUsualResidence;
    }

    @Override
    public String getUntrackedFatherUsualResidence() {
        return untrackedFatherUsualResidence;
    }

    @Override
    public void setUntrackedFatherUsualResidence(String untrackedFatherUsualResidence) {
        this.untrackedFatherUsualResidence = untrackedFatherUsualResidence;
    }

    @Override
    public String getInformantResidence() {
        return informantResidence;
    }

    @Override
    public void setInformantResidence(String informantResidence) {
        this.informantResidence = informantResidence;
    }

    @Override
    public Place getMotherUsualResidence() {
        return motherUsualResidence;
    }

    @Override
    public void setMotherUsualResidence(Place motherUsualResidence) {
        this.motherUsualResidence = motherUsualResidence;
    }

    @Override
    public String getUntrackedMotherUsualResidence() {
        return untrackedMotherUsualResidence;
    }

    @Override
    public void setUntrackedMotherUsualResidence(String untrackedMotherUsualResidence) {
        this.untrackedMotherUsualResidence = untrackedMotherUsualResidence;
    }
}
