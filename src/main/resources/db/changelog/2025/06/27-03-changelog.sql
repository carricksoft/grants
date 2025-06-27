/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1751020095145-1


-- changeset apg:1751020095145-8
ALTER TABLE birth_certificate
    ADD CONSTRAINT FK_BIRTHCERTIFICATE_ON_WHERE_BORN FOREIGN KEY (where_born_id) REFERENCES place (id);

