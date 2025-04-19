/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1745088309419-2
ALTER TABLE census
    ADD boundary_type VARCHAR(255) NULL;

