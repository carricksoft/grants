/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.deathcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.general.Sex;

public class DeathCertificateCommandImpl implements DeathCertificateCommand {

    Long Id;
    private Person deceased;
    private Person father;
    private Person informant;
    private Person mother;
    private Person spouse;
    private Place usualResidence;
    private Place whereDied;
    private Sex sex;
    private String age;
    private String causeOfDeath;
    private String fatherOccupation;
    private String informantAddress;
    private String informantQualification;
    private String maritalStatus;
    private String motherOccupation;
    private String occupation;
    private String spouseOccupation;
    private String untrackedFather;
    private String untrackedInformant;
    private String untrackedMother;
    private String untrackedSpouse;
    private String untrackedUsualResidence;
    private String untrackedWhereDied;
    private String whenBorn;
    private String whenDied;
    private String whenRegistered;
    private String whereRegistered;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getDeceased() {
        return deceased;
    }

    @Override
    public void setDeceased(Person deceased) {
        this.deceased = deceased;
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
    public Person getInformant() {
        return informant;
    }

    @Override
    public void setInformant(Person informant) {
        this.informant = informant;
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
    public Person getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public Place getUsualResidence() {
        return usualResidence;
    }

    @Override
    public void setUsualResidence(Place usualResidence) {
        this.usualResidence = usualResidence;
    }

    @Override
    public Place getWhereDied() {
        return whereDied;
    }

    @Override
    public void setWhereDied(Place whereDied) {
        this.whereDied = whereDied;
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
    public String getAge() {
        return age;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    @Override
    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    @Override
    public String getFatherOccupation() {
        return fatherOccupation;
    }

    @Override
    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    @Override
    public String getInformantAddress() {
        return informantAddress;
    }

    @Override
    public void setInformantAddress(String informantAddress) {
        this.informantAddress = informantAddress;
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
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String getMotherOccupation() {
        return motherOccupation;
    }

    @Override
    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    @Override
    public String getOccupation() {
        return occupation;
    }

    @Override
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String getSpouseOccupation() {
        return spouseOccupation;
    }

    @Override
    public void setSpouseOccupation(String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
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
    public String getUntrackedInformant() {
        return untrackedInformant;
    }

    @Override
    public void setUntrackedInformant(String untrackedInformant) {
        this.untrackedInformant = untrackedInformant;
    }

    @Override
    public String getUntrackedMother() {
        return untrackedMother;
    }

    @Override
    public void setUntrackedMother(String untrackedMother) {
        this.untrackedMother = untrackedMother;
    }

    @Override
    public String getUntrackedSpouse() {
        return untrackedSpouse;
    }

    @Override
    public void setUntrackedSpouse(String untrackedSpouse) {
        this.untrackedSpouse = untrackedSpouse;
    }

    @Override
    public String getUntrackedUsualResidence() {
        return untrackedUsualResidence;
    }

    @Override
    public void setUntrackedUsualResidence(String untrackedUsualResidence) {
        this.untrackedUsualResidence = untrackedUsualResidence;
    }

    @Override
    public String getUntrackedWhereDied() {
        return untrackedWhereDied;
    }

    @Override
    public void setUntrackedWhereDied(String untrackedWhereDied) {
        this.untrackedWhereDied = untrackedWhereDied;
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
    public String getWhenDied() {
        return whenDied;
    }

    @Override
    public void setWhenDied(String whenDied) {
        this.whenDied = whenDied;
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
}
