/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1745400882072-4
ALTER TABLE person
    ADD certified_year_of_birth VARCHAR(255) NULL,
    ADD recorded_year_of_birth  VARCHAR(255) NULL;
