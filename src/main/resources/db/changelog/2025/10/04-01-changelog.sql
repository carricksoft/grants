/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1759570040134-1
ALTER TABLE person
    ADD image_id BIGINT NULL;

