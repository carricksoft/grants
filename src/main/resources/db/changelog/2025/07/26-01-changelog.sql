/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1753557049320-1
ALTER TABLE death_certificate
    ADD regiment       VARCHAR(255) NULL,
    ADD service_number VARCHAR(255) NULL,
    ADD service_rank   VARCHAR(255) NULL;

