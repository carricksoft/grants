/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1753212193644-1
ALTER TABLE death_certificate
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_INFORMANT FOREIGN KEY (informant_id) REFERENCES person (id);


