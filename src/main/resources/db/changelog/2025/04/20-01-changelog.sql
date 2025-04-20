/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql


-- changeset apg:1745161135116-1
ALTER TABLE `census`
    DROP COLUMN IF EXISTS `date`;

-- changeset apg:1745161135116-2
ALTER TABLE `census`
    ADD `census_date` VARCHAR(255);

