/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1747942334737-1
ALTER TABLE census
    ADD people_in_houses VARCHAR(255) NULL;

