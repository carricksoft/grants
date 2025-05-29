/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import jakarta.persistence.Column;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.places.Place;


@MappedSuperclass
public class BaseCertificate extends BaseEntity {

    @Column(name = "`certificate_number`")
    private String certificateNumber;

    @ManyToOne
    @JoinColumn(name = "`place_id`")
    private Place certificateIssuedAt;

    @Column(name= "`certificate_date`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String certificateDate;

    @SuppressWarnings("unused")
    public String getCertificateNumber() {
        return certificateNumber;
    }

    @SuppressWarnings("unused")
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @SuppressWarnings("unused")
    public Place getCertificateIssuedAt() {
        return certificateIssuedAt;
    }

    @SuppressWarnings("unused")
    public void setCertificateIssuedAt(Place certificateIssuedAt) {
        this.certificateIssuedAt = certificateIssuedAt;
    }

    @SuppressWarnings("unused")
    public String getCertificateDate() {
        return certificateDate;
    }

    @SuppressWarnings("unused")
    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }
}
