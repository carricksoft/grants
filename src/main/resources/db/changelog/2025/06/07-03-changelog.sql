/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql



-- changeset apg:1749297471091-7
ALTER TABLE birth_certificate
    ADD CONSTRAINT FK_BIRTHCERTIFICATE_ON_MOTHER FOREIGN KEY (mother_id) REFERENCES person (id);

