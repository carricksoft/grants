/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1747732865690-1
ALTER TABLE `census_entry`
    ADD  COLUMN  IF NOT EXISTS `children_born_alive`       VARCHAR(255) NULL,
    ADD  COLUMN  IF NOT EXISTS `children_still_alive`      VARCHAR(255) NULL,
    ADD  COLUMN  IF NOT EXISTS `children_who_have_died`    VARCHAR(255) NULL,
    ADD  COLUMN  IF NOT EXISTS `years_completed_marriage`  VARCHAR(255) NULL;

-- changeset apg:1747732865690-4
ALTER TABLE `census`
    ADD  COLUMN  IF NOT EXISTS `inhabited_houses`    VARCHAR(255) NULL,
    ADD  COLUMN  IF NOT EXISTS `rooms_occupied`      VARCHAR(255) NULL,
    ADD  COLUMN  IF NOT EXISTS `total_rooms`         VARCHAR(255) NULL,
    ADD  COLUMN  IF NOT EXISTS `uninhabited_houses`  VARCHAR(255) NULL;

