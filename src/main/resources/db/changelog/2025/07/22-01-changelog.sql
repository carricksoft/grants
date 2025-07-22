/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1753211344350-1
ALTER TABLE death_certificate
    ADD age                       VARCHAR(255) NULL,
    ADD cause_of_death            LONGTEXT     NULL,
    ADD certificate_date          VARCHAR(255) NULL,
    ADD certificate_number        VARCHAR(255) NULL,
    ADD certificate_type          VARCHAR(255) NULL,
    ADD father_id                 BIGINT       NULL,
    ADD father_occupation         VARCHAR(255) NULL,
    ADD informant_address         VARCHAR(255) NULL,
    ADD informant_id              BIGINT       NULL,
    ADD informant_qualification   VARCHAR(255) NULL,
    ADD marital_status            VARCHAR(255) NULL,
    ADD mother_id                 BIGINT       NULL,
    ADD mother_occupation         VARCHAR(255) NULL,
    ADD number                    VARCHAR(255) NULL,
    ADD occupation                VARCHAR(255) NULL,
    ADD organisation_id           BIGINT       NULL,
    ADD registration_authority    BIGINT       NULL,
    ADD sex                       VARCHAR(255) NULL,
    ADD spouse_id                 BIGINT       NULL,
    ADD spouse_occupation         VARCHAR(255) NULL,
    ADD untracked_father          VARCHAR(255) NULL,
    ADD untracked_informant       VARCHAR(255) NULL,
    ADD untracked_mother          VARCHAR(255) NULL,
    ADD untracked_spouse          VARCHAR(255) NULL,
    ADD untracked_usual_residence VARCHAR(255) NULL,
    ADD untracked_where_died      VARCHAR(255) NULL,
    ADD usual_residence_id        BIGINT       NULL,
    ADD volume                    VARCHAR(255) NULL,
    ADD when_born                 VARCHAR(255) NULL,
    ADD when_died                 VARCHAR(255) NULL,
    ADD when_registered           VARCHAR(255) NULL,
    ADD where_died_id             BIGINT       NULL,
    ADD where_registered          VARCHAR(255) NULL;

