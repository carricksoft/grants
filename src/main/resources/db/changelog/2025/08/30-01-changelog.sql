/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1756549191884-1
ALTER TABLE divorce_certificate
    ADD first_party_date  VARCHAR(255) NULL,
    ADD registered_date   VARCHAR(255) NULL,
    ADD second_party_date VARCHAR(255) NULL;

