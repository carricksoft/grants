/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1760427435610-1
ALTER TABLE person_image
    ADD caption  VARCHAR(255) NULL,
    ADD height   VARCHAR(255) NULL,
    ADD image_id BIGINT       NULL,
    ADD level    VARCHAR(255) NULL,
    ADD `order`  VARCHAR(255) NULL,
    ADD width    VARCHAR(255) NULL;



