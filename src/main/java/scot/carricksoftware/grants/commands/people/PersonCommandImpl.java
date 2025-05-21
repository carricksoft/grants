/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.people;

import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.domains.text.PersonText;

import java.util.ArrayList;
import java.util.List;

public class PersonCommandImpl implements PersonCommand {

    private Long Id;

    private String firstName;

    private String lastName;

    private String recordedYearOfBirth;

    private String certifiedYearOfBirth;

    private List<BirthCertificate> birthCertificates = new ArrayList<>();

    private List<DeathCertificate> deathCertificates = new ArrayList<>();

    private List<MarriageCertificate> marriageCertificates = new ArrayList<>();

    private List<DivorceCertificate> divorceCertificates = new ArrayList<>();

    private List<CensusEntry> censusEntries = new ArrayList<>();

    private List<PersonImage> personImages = new ArrayList<>();

    private List<PersonText> personTexts = new ArrayList<>();


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getRecordedYearOfBirth() {
        return recordedYearOfBirth;
    }

    @Override
    public void setRecordedYearOfBirth(String recordedYearOfBirth) {
        this.recordedYearOfBirth = recordedYearOfBirth;
    }

    @Override
    public String getCertifiedYearOfBirth() {
        return certifiedYearOfBirth;
    }

    @Override
    public void setCertifiedYearOfBirth(String certifiedYearOfBirth) {
        this.certifiedYearOfBirth = certifiedYearOfBirth;
    }

    @Override
    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    @Override
    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }

    @Override
    public List<DeathCertificate> getDeathCertificates() {
        return deathCertificates;
    }

    @Override
    public void setDeathCertificates(List<DeathCertificate> deathCertificates) {
        this.deathCertificates = deathCertificates;
    }

    @Override
    public List<MarriageCertificate> getMarriageCertificates() {
        return marriageCertificates;
    }

    @Override
    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
        this.marriageCertificates = marriageCertificates;
    }

   @Override
   public List<DivorceCertificate> getDivorceCertificates() {
        return divorceCertificates;
    }

    @Override
    public void setDivorceCertificates(List<DivorceCertificate> divorceCertificates) {
        this.divorceCertificates = divorceCertificates;
    }

    @Override
    public List<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    @Override
    public void setCensusEntries(List<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    @Override
    public List<PersonImage> getPersonImages() {
        return personImages;
    }

    @Override
    public void setPersonImages(List<PersonImage> personImages) {
        this.personImages = personImages;
    }

    @Override
    public List<PersonText> getPersonTexts() {
        return personTexts;
    }

    @Override
    public void setPersonTexts(List<PersonText> personTexts) {
        this.personTexts = personTexts;
    }


}
