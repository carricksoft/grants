/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql


-- changeset apg:1750320865822-2
ALTER TABLE birth_certificate
    DROP COLUMN where_born;

