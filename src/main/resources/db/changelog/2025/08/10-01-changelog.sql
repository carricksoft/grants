/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1754784691547-1
ALTER TABLE marriage_certificate
    ADD bride_age                 VARCHAR(255) NULL,
    ADD bride_condition           VARCHAR(255) NULL,
    ADD bride_father              BIGINT       NULL,
    ADD bride_father_rank         VARCHAR(255) NULL,
    ADD bride_rank                VARCHAR(255) NULL,
    ADD bride_residence_id        BIGINT       NULL,
    ADD bride_untracked_father    VARCHAR(255) NULL,
    ADD bride_untracked_residence VARCHAR(255) NULL,
    ADD certificate_date          VARCHAR(255) NULL,
    ADD certificate_number        VARCHAR(255) NULL,
    ADD certificate_type          VARCHAR(255) NULL,
    ADD first_witness             BIGINT       NULL,
    ADD groom_age                 VARCHAR(255) NULL,
    ADD groom_condition           VARCHAR(255) NULL,
    ADD groom_father              BIGINT       NULL,
    ADD groom_father_rank         VARCHAR(255) NULL,
    ADD groom_rank                VARCHAR(255) NULL,
    ADD groom_residence_id        BIGINT       NULL,
    ADD groom_untracked_father    VARCHAR(255) NULL,
    ADD groom_untracked_residence VARCHAR(255) NULL,
    ADD number                    VARCHAR(255) NULL,
    ADD organisation_id           BIGINT       NULL,
    ADD registration_authority    BIGINT       NULL,
    ADD second_witness            BIGINT       NULL,
    ADD untracked_first_witness   VARCHAR(255) NULL,
    ADD untracked_second_witness  VARCHAR(255) NULL,
    ADD untracked_where_married   VARCHAR(255) NULL,
    ADD volume                    VARCHAR(255) NULL,
    ADD when_married              VARCHAR(255) NULL,
    ADD where_married_id          BIGINT       NULL;

