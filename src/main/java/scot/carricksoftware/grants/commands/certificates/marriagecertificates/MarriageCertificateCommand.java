/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriagecertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

public interface MarriageCertificateCommand {


    Long getId();

    void setId(Long id);


    Person getBride();

    void setBride(Person bride);

    Person getGroom();

    void setGroom(Person groom);

    String getWhenMarried();

    void setWhenMarried(String whenMarried);

    Place getWhereMarried();

    void setWhereMarried(Place whereMarried);

    String getUntrackedWhereMarried();

    void setUntrackedWhereMarried(String untrackedWhereMarried);

    String getGroomAge();

    void setGroomAge(String groomAge);

    String getBrideAge();

    void setBrideAge(String brideAge);

    String getGroomCondition();

    void setGroomCondition(String groomCondition);

    String getBrideCondition();

    void setBrideCondition(String brideCondition);

    String getGroomRank();

    void setGroomRank(String groomRank);

    String getBrideRank();

    void setBrideRank(String brideRank);

    Place getGroomUsualResidence();

    void setGroomUsualResidence(Place groomUsualResidence);

    Place getBrideUsualResidence();

    void setBrideUsualResidence(Place brideUsualResidence);

    String getGroomUntrackedResidence();

    void setGroomUntrackedResidence(String groomUntrackedResidence);

    String getBrideUntrackedResidence();

    void setBrideUntrackedResidence(String brideUntrackedResidence);

    Person getGroomFather();

    void setGroomFather(Person groomFather);

    Person getBrideFather();

    void setBrideFather(Person brideFather);

    String getGroomUntrackedFather();

    void setGroomUntrackedFather(String groomUntrackedFather);

    String getBrideUntrackedFather();

    void setBrideUntrackedFather(String brideUntrackedFather);

    String getBrideFatherRank();

    void setBrideFatherRank(String brideFatherRank);

    Person getFirstWitness();

    void setFirstWitness(Person firstWitness);

    Person getSecondWitness();

    void setSecondWitness(Person secondWitness);

    String getUntrackedFirstWitness();

    void setUntrackedFirstWitness(String untrackedFirstWitness);

    String getUntrackedSecondWitness();

    void setUntrackedSecondWitness(String untrackedSecondWitness);

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

    String getGroomFatherRank();

    void setGroomFatherRank(String groomFatherRank);

    String getYearMarried();

    void setYearMarried(String yearMarried);

    String getDayMarried();

    void setDayMarried(String dayMarried);

    String getMonthMarried();

    void setMonthMarried(String monthMarried);
}
