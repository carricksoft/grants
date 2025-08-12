/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1755006033415-1
ALTER TABLE marriage_certificate
    ADD day_married   VARCHAR(255) NULL,
    ADD month_married VARCHAR(255) NULL,
    ADD year_married  VARCHAR(255) NULL;

