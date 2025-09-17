/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1756889071553-1
ALTER TABLE person_text
    ADD content LONGTEXT     NULL,
    ADD heading VARCHAR(255) NULL,
    ADD level   BIGINT       NULL,
    ADD `order` BIGINT       NULL;

