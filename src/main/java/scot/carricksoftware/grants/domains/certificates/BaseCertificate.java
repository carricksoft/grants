/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import jakarta.persistence.Column;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.places.Place;

import java.sql.Date;


@MappedSuperclass
public class BaseCertificate extends BaseEntity {

    @Column(name = "`certificate_number`")
    private String certificateNumber;

    @ManyToOne
    @JoinColumn(name = "`place_id`")
    private Place certificateIssuedAt;

    @Column(name= "`certificate_date`")
    @Temporal(TemporalType.DATE)
    private Date certificateDate;

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
    public Date getCertificateDate() {
        return certificateDate;
    }

    @SuppressWarnings("unused")
    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }
}
