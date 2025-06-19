/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1750320865822-1
ALTER TABLE birth_certificate
    ADD untracked_where_born VARCHAR(255) NULL;


