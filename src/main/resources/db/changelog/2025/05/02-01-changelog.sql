/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1746197059682-1
ALTER TABLE census_entry
    ADD notes VARCHAR(255) NULL;

