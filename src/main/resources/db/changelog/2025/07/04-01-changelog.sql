/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751586990584-1
ALTER TABLE birth_certificate
    ADD mother_usual_residence_id        BIGINT       NULL,
    ADD untracked_mother_usual_residence VARCHAR(255) NULL;
