/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.deathcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.enums.general.Sex;

public interface DeathCertificateCommand {


    Long getId();
    Person getDeceased();
    Person getFather();
    Person getInformant();
    Person getMother();
    Person getSpouse();
    Place getUsualResidence();
    Place getWhereDied();
    Sex getSex();
    String getAge();
    String getCauseOfDeath();
    String getFatherOccupation();
    String getInformantAddress();
    String getInformantQualification();
    String getMaritalStatus();
    String getMotherOccupation();
    String getOccupation();
    String getSpouseOccupation();
    String getUntrackedFather();
    String getUntrackedInformant();
    String getUntrackedMother();
    String getUntrackedSpouse();
    String getUntrackedUsualResidence();
    String getUntrackedWhereDied();
    String getWhenBorn();
    String getWhenDied();
    String getWhenRegistered();
    String getWhereRegistered();
    void setAge(String age);
    void setCauseOfDeath(String causeOfDeath);
    void setDeceased(Person deceased);
    void setFather(Person father);
    void setFatherOccupation(String fatherOccupation);
    void setId(Long id);
    void setInformant(Person informant);
    void setInformantAddress(String informantAddress);
    void setInformantQualification(String informantQualification);
    void setMaritalStatus(String maritalStatus);
    void setMother(Person mother);
    void setMotherOccupation(String motherOccupation);
    void setOccupation(String occupation);
    void setSex(Sex sex);
    void setSpouse(Person spouse);
    void setSpouseOccupation(String spouseOccupation);
    void setUntrackedFather(String untrackedFather);
    void setUntrackedInformant(String untrackedInformant);
    void setUntrackedMother(String untrackedMother);
    void setUntrackedSpouse(String untrackedSpouse);
    void setUntrackedUsualResidence(String untrackedUsualResidence);
    void setUntrackedWhereDied(String untrackedWhereDied);
    void setUsualResidence(Place usualResidence);
    void setWhenBorn(String whenBorn);
    void setWhenDied(String whenDied);
    void setWhenRegistered(String whenRegistered);
    void setWhereDied(Place whereDied);
    void setWhereRegistered(String whereRegistered);

    String getCertificateNumber();

    void setCertificateNumber(String certificateNumber);

    Organisation getCertificateSource();

    void setCertificateSource(Organisation certificateSource);

    String getCertificateDate();

    void setCertificateDate(String certificateDate);

    CertificateType getCertificateType();

    void setCertificateType(CertificateType certificateType);

    Organisation getRegistrationAuthority();

    void setRegistrationAuthority(Organisation registrationAuthority);

    String getVolume();

    void setVolume(String volume);

    String getNumber();

    void setNumber(String number);
}
