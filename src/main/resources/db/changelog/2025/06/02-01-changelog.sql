/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1748821997702-1
ALTER TABLE `birth_certificate`
    ADD `number`                 VARCHAR(255) NULL,
    ADD `registration_authority` BIGINT       NULL,
    ADD `volume`                 VARCHAR(255) NULL;



