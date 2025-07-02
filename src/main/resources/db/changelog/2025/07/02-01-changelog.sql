/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751447498983-1
ALTER TABLE birth_certificate
    ADD informant_residence VARCHAR(255) NULL;

