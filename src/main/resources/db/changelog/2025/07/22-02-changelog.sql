/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1753212193644-1
ALTER TABLE death_certificate
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_FATHER FOREIGN KEY (father_id) REFERENCES person (id);


