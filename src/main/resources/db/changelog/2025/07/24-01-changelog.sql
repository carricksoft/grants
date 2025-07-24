/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1753312187713-1
ALTER TABLE person
    ADD certified_year_of_death VARCHAR(255) NULL;

