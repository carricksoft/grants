/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1749297471091-1
ALTER TABLE birth_certificate
    ADD date_and_place_of_marriage VARCHAR(255) NULL,
    ADD father_id                  BIGINT       NULL,
    ADD father_rank                VARCHAR(255) NULL,
    ADD mother_id                  BIGINT       NULL,
    ADD untracked_father           VARCHAR(255) NULL;


