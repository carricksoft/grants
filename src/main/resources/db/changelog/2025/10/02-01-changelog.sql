/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1759425457477-1
ALTER TABLE image
    ADD file_name  VARCHAR(255) NULL,
    ADD image_data LONGTEXT     NULL,
    ADD name       VARCHAR(255) NULL;

