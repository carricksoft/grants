/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751374845476-1
ALTER TABLE birth_certificate
    ADD father_usual_residence_id        BIGINT       NULL,
    ADD untracked_father_usual_residence VARCHAR(255) NULL;

-- changeset apg:1751374845476-3
ALTER TABLE birth_certificate
    ADD CONSTRAINT FK_BIRTHCERTIFICATE_ON_FATHER_USUAL_RESIDENCE FOREIGN KEY (father_usual_residence_id) REFERENCES place (id);

