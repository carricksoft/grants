/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1747073212310-1
ALTER TABLE census
    ADD total_rooms VARCHAR(255) NULL;

