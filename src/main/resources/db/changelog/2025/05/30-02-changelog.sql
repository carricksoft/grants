/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1748568126411-1
ALTER TABLE birth_certificate
    ADD CONSTRAINT FK_BIRTHCERTIFICATE_ON_PLACE FOREIGN KEY (place_id) REFERENCES place (id);

