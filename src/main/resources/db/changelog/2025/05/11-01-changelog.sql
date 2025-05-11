/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1746999851556-1
ALTER TABLE census
    ADD filled_in_by VARCHAR(255) NULL;


