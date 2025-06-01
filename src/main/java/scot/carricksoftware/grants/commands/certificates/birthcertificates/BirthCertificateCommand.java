/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:51. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.birthcertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.enums.certificates.CertificateType;

public interface BirthCertificateCommand {

    Long getId();

    void setId(Long id);

    Person getNewBorn();

    void setNewBorn(Person newBorn);

    @SuppressWarnings("unused")
    String getCertificateNumber();

    @SuppressWarnings("unused")
    void setCertificateNumber(String certificateNumber);

    @SuppressWarnings("unused")
    Organisation getCertificateSource();

    @SuppressWarnings("unused")
    void setCertificateSource(Organisation certificateSource);

    @SuppressWarnings("unused")
    String getCertificateDate();

    @SuppressWarnings("unused")
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
