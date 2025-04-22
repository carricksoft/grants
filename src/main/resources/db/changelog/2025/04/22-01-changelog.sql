/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1745301546038-1

-- changeset apg:1745301546038-2
ALTER TABLE census
    ADD inhabited_rooms    VARCHAR(255) NULL,
    ADD rooms_with_windows VARCHAR(255) NULL;


