/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1744877825545-1
ALTER TABLE census_entry
    ADD age          VARCHAR(255) NULL,
    ADD where_born   VARCHAR(255) NULL;

