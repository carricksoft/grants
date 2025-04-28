/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1745857129623-1
ALTER TABLE census_entry
    ADD COLUMN IF NOT EXISTS age          VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS birth_day    VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS birth_year   VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS `condition`  VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS gaelic       VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS relationship VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS sex          VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS where_born   VARCHAR(255) NULL,
    ADD COLUMN IF NOT EXISTS worker       VARCHAR(255) NULL;

