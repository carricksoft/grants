/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751374417575-3
ALTER TABLE birth_certificate
    ADD CONSTRAINT FK_BIRTHCERTIFICATE_ON_FATHER_USUAL_RESIDENCE FOREIGN KEY (father_usual_residence_id) REFERENCES place (id);

