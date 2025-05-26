/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1748284966359-1
ALTER TABLE census_entry
    ADD industry_or_service VARCHAR(255) NULL,
    ADD working_at_home     VARCHAR(255) NULL;



