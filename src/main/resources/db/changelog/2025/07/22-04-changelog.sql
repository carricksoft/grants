/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1753212193644-1
ALTER TABLE death_certificate
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_MOTHER FOREIGN KEY (mother_id) REFERENCES person (id),
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_ORGANISATION FOREIGN KEY (organisation_id) REFERENCES organisation (id);


