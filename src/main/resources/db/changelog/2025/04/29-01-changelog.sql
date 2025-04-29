-- liquibase formatted sql

-- changeset apg:1745966382217-24
ALTER TABLE census_entry
    DROP FOREIGN KEY IF EXISTS FK_CENSUSENTRY_ON_CENSUSENTRY_CENSUS;

-- changeset apg:1745966382217-25
ALTER TABLE census
    DROP FOREIGN KEY IF EXISTS FK_CENSUS_ON_CENSUS_PLACE;

-- changeset apg:1745966382217-26
ALTER TABLE place
    DROP FOREIGN KEY IF EXISTS FK_PLACE_ON_PLACE_REGION;

-- changeset apg:1745966382217-27
ALTER TABLE region
    DROP FOREIGN KEY IF EXISTS FK_REGION_ON_REGION_COUNTRY;

-- changeset apg:1745966382217-1
ALTER TABLE census_entry
    ADD IF NOT EXISTS age          VARCHAR(255) NULL,
    ADD IF NOT EXISTS birth_day    VARCHAR(255) NULL,
    ADD IF NOT EXISTS birth_year   VARCHAR(255) NULL,
    ADD IF NOT EXISTS census_id    BIGINT       NULL,
    ADD IF NOT EXISTS `condition`  VARCHAR(255) NULL,
    ADD IF NOT EXISTS gaelic       VARCHAR(255) NULL,
    ADD IF NOT EXISTS relationship VARCHAR(255) NULL,
    ADD IF NOT EXISTS sex          VARCHAR(255) NULL,
    ADD IF NOT EXISTS where_born   VARCHAR(255) NULL,
    ADD IF NOT EXISTS worker       VARCHAR(255) NULL;

-- changeset apg:1745966382217-4
ALTER TABLE census
    ADD IF NOT EXISTS boundary_type      VARCHAR(255) NULL,
    ADD IF NOT EXISTS census_date        VARCHAR(255) NULL,
    ADD IF NOT EXISTS inhabited_rooms    VARCHAR(255) NULL,
    ADD IF NOT EXISTS place_id           BIGINT       NULL,
    ADD IF NOT EXISTS rooms_with_windows VARCHAR(255) NULL;

-- changeset apg:1745966382217-7
ALTER TABLE person
    ADD IF NOT EXISTS certified_year_of_birth VARCHAR(255) NULL,
    ADD IF NOT EXISTS recorded_year_of_birth  VARCHAR(255) NULL;

-- changeset apg:1745966382217-9
ALTER TABLE region
    ADD IF NOT EXISTS country_id BIGINT NULL;

-- changeset apg:1745966382217-14
ALTER TABLE place
    ADD IF NOT EXISTS region_id BIGINT NULL;

-- changeset apg:1745966382217-20
ALTER TABLE census_entry
    ADD CONSTRAINT  FK_CENSUSENTRY_ON_CENSUS FOREIGN KEY (census_id) REFERENCES census (id);

/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- changeset apg:1745966382217-21
ALTER TABLE census
    ADD CONSTRAINT FK_CENSUS_ON_PLACE FOREIGN KEY (place_id) REFERENCES place (id);

-- changeset apg:1745966382217-22
ALTER TABLE place
    ADD CONSTRAINT  FK_PLACE_ON_REGION FOREIGN KEY (region_id) REFERENCES region (id);

-- changeset apg:1745966382217-23
ALTER TABLE region
    ADD CONSTRAINT FK_REGION_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES country (id);

-- changeset apg:1745966382217-28
ALTER TABLE census_entry
    DROP COLUMN IF EXISTS census_entry_census_id;

-- changeset apg:1745966382217-29
ALTER TABLE census
    DROP COLUMN IF EXISTS census_place_id;
ALTER TABLE census
    DROP COLUMN IF EXISTS `date`;

-- changeset apg:1745966382217-31
ALTER TABLE place
    DROP COLUMN IF EXISTS place_region_id;

-- changeset apg:1745966382217-32
ALTER TABLE IF EXISTS region
    DROP COLUMN region_country_id;

