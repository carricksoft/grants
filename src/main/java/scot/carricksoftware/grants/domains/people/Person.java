/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.people;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.census.CensusEntry;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.images.PersonImage;
import scot.carricksoftware.grants.domains.text.PersonText;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "`image_id`")
    private Image image;

    @Column(name = "`first_name`")
    private String firstName;

    @Column(name = "`last_name`")
    String lastName;

    @Column(name = "`recorded_year_of_birth`")
    String recordedYearOfBirth;

    @Column(name = "`certified_year_of_birth`")
    String certifiedYearOfBirth;

    @Column(name = "`certified_year_of_death`")
    String certifiedYearOfDeath;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BirthCertificate> birthCertificates = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeathCertificate> deathCertificates = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarriageCertificate> marriageCertificates = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DivorceCertificate> divorceCertificates = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CensusEntry> censusEntries = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonImage> personImages = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonText> personTexts = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.lastName);
        builder.append(", ");
        builder.append(this.firstName);
        builder.append(", ");
        if (certifiedYearOfBirth != null && !certifiedYearOfBirth.isEmpty())  {
            builder.append(certifiedYearOfBirth);
            builder.append(" ");
        }  else {
            if (recordedYearOfBirth != null && !recordedYearOfBirth.isEmpty())  {
                builder.append("(");
                builder.append(recordedYearOfBirth);
                builder.append(")");
                builder.append(" ");
            }
        }
        builder.append("-");
        if (certifiedYearOfDeath != null && !certifiedYearOfDeath.isEmpty())  {
            builder.append(" ");
            builder.append(certifiedYearOfDeath);
        }

        return builder.toString();
    }

    public String getRecordedYearOfBirth() {
        return recordedYearOfBirth;
    }

    public void setRecordedYearOfBirth(String recordedYearOfBirth) {
        this.recordedYearOfBirth = recordedYearOfBirth;
    }

    public String getCertifiedYearOfBirth() {
        return certifiedYearOfBirth;
    }

    public void setCertifiedYearOfBirth(String certifiedYearOfBirth) {
        this.certifiedYearOfBirth = certifiedYearOfBirth;
    }

    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }

    public List<DeathCertificate> getDeathCertificates() {
        return deathCertificates;
    }

    public void setDeathCertificates(List<DeathCertificate> deathCertificates) {
        this.deathCertificates = deathCertificates;
    }

    public List<MarriageCertificate> getMarriageCertificates() {
        return marriageCertificates;
    }

    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
        this.marriageCertificates = marriageCertificates;
    }

    public List<DivorceCertificate> getDivorceCertificates() {
        return divorceCertificates;
    }

    public void setDivorceCertificates(List<DivorceCertificate> divorceCertificates) {
        this.divorceCertificates = divorceCertificates;
    }

    public List<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    public void setCensusEntries(List<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    public List<PersonImage> getPersonImages() {
        return personImages;
    }

    public void setPersonImages(List<PersonImage> personImages) {
        this.personImages = personImages;
    }

    public List<PersonText> getPersonTexts() {
        return personTexts;
    }

    public void setPersonTexts(List<PersonText> personTexts) {
        this.personTexts = personTexts;
    }

    public String getCertifiedYearOfDeath() {
        return certifiedYearOfDeath;
    }

    public void setCertifiedYearOfDeath(String certifiedYearOfDeath) {
        this.certifiedYearOfDeath = certifiedYearOfDeath;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
