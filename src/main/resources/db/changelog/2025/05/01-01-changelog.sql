/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1746138422017-1
ALTER TABLE census_entry
    ADD personal_occupation VARCHAR(255) NULL;

