/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1745685836198-1
ALTER TABLE census_entry
    ADD sex          VARCHAR(255) NULL;



