/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1758399661903-4
ALTER TABLE person_text
    ADD `order` VARCHAR(255) NULL;

