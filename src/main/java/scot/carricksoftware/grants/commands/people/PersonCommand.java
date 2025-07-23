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

import java.util.List;

public interface PersonCommand {

    Long getId();

    void setId(Long id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getRecordedYearOfBirth();

    void setRecordedYearOfBirth(String recordedYearOfBirth);

    String getCertifiedYearOfBirth();

    void setCertifiedYearOfBirth(String certifiedYearOfBirth);

    List<BirthCertificate> getBirthCertificates();

    void setBirthCertificates(List<BirthCertificate> birthCertificates);

    List<DeathCertificate> getDeathCertificates();

    void setDeathCertificates(List<DeathCertificate> deathCertificates);

    List<MarriageCertificate> getMarriageCertificates();

    void setMarriageCertificates(List<MarriageCertificate> marriageCertificates);

    List<DivorceCertificate> getDivorceCertificates();

    void setDivorceCertificates(List<DivorceCertificate> divorceCertificates);

    List<CensusEntry> getCensusEntries();

    void setCensusEntries(List<CensusEntry> censusEntries);

    List<PersonImage> getPersonImages();

    void setPersonImages(List<PersonImage> personImages);

    List<PersonText> getPersonTexts();

    void setPersonTexts(List<PersonText> personTexts);

    String getCertifiedYearOfDeath();

    void setCertifiedYearOfDeath(String certifiedYearOfDeath);
}
