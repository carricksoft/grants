/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1748566637297-1
ALTER TABLE `birth_certificate`
    ADD COLUMN  IF NOT EXISTS `certificate_date`   VARCHAR(255) NULL,
    ADD COLUMN  IF NOT EXISTS `certificate_number` VARCHAR(255) NULL,
    ADD COLUMN  IF NOT EXISTS `place_id`           BIGINT       NULL;



