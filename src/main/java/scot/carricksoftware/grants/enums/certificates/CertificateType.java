/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.enums.certificates;

public enum CertificateType {

    COPY("Copy"),
    EXTRACT("Extract");

    public final String label;

    @SuppressWarnings({"unused", "SameParameterValue"})
    CertificateType(String label) {
        this.label = label;
    }
}
