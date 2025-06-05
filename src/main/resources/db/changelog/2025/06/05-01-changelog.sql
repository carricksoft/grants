/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1749111049135-1
ALTER TABLE birth_certificate
    ADD sex        VARCHAR(255) NULL,
    ADD when_born  VARCHAR(255) NULL,
    ADD where_born VARCHAR(255) NULL;

