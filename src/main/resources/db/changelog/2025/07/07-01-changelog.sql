/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751878720346-1
ALTER TABLE birth_certificate
    ADD father_place_of_birth VARCHAR(255) NULL,
    ADD mother_place_of_birth VARCHAR(255) NULL;

