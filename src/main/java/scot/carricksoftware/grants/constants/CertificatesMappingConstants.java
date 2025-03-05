/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class CertificatesMappingConstants {

    private CertificatesMappingConstants() {
        // to stop checkstyle complaining
    }


    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_LIST = "/birthCertificates";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_NEXT = "/birthCertificates/next";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_PREVIOUS = "/birthCertificates/prev";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_REWIND = "/birthCertificates/rewind";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_FF = "/birthCertificates/ff";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_NEW = "/birthCertificate/new";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE = "/birthCertificate";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_SHOW = "/birthCertificate/{id}/show";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_DELETE = "/birthCertificate/{id}/delete";
    @SuppressWarnings("unused")
    public static final String BIRTHCERTIFICATE_EDIT = "birthCertificate/{id}/edit";
}
