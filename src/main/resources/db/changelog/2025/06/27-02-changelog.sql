/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751020095145-7
ALTER TABLE birth_certificate
    ADD CONSTRAINT FK_BIRTHCERTIFICATE_ON_INFORMANT FOREIGN KEY (informant_id) REFERENCES person (id);


