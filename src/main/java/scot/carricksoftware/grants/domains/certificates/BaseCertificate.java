/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import jakarta.persistence.Column;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.certificates.CertificateType;


@MappedSuperclass
public class BaseCertificate extends BaseEntity {

    @Column(name = "`certificate_number`")
    private String certificateNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "`certificate_type`")
    private CertificateType certificateType;

    @ManyToOne
    @JoinColumn(name = "`organisation_id`")
    private Organisation certificateSource;

    @Column(name= "`certificate_date`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String certificateDate;

    @ManyToOne
    @JoinColumn(name = "`registration_authority`")
    private Place registrationAuthority;

    @Column(name = "`volume`")
    private String volume;

    @Column(name = "`Number`")
    private String number;

    @SuppressWarnings("unused")
    public String getCertificateNumber() {
        return certificateNumber;
    }

    @SuppressWarnings("unused")
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Organisation getCertificateSource() {
        return certificateSource;
    }


    @SuppressWarnings("unused")
    public String getCertificateDate() {
        return certificateDate;
    }

    @SuppressWarnings("unused")
    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }

    public void setCertificateSource(Organisation organisation) {
        this.certificateSource = organisation;
    }

    public CertificateType getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(CertificateType certificateType) {
        this.certificateType = certificateType;
    }

    public Place getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(Place registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
