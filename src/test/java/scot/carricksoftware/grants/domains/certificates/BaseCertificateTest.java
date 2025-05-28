/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.certificates;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BaseCertificateTest {

    private BaseCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new BaseCertificate();
    }

    @Test
    void dummyTest(){
        assertNotNull(certificate);
    }

}