/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1747128971697-1
ALTER TABLE census_entry
    ADD children_born_alive      VARCHAR(255) NULL,
    ADD children_still_alive     VARCHAR(255) NULL,
    ADD children_who_have_died   VARCHAR(255) NULL,
    ADD years_completed_marriage VARCHAR(255) NULL;


