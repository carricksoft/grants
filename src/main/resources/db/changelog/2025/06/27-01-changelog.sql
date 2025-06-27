/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751020095145-1
ALTER TABLE birth_certificate
    ADD informant_id            BIGINT       NULL,
    ADD informant_qualification VARCHAR(255) NULL,
    ADD untracked_informant     VARCHAR(255) NULL,
    ADD when_registered         VARCHAR(255) NULL,
    ADD where_born_id           BIGINT       NULL,
    ADD where_registered        VARCHAR(255) NULL;


