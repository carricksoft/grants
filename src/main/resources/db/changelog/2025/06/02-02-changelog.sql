/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql


-- changeset apg:1748821997702-4
ALTER TABLE `birth_certificate`
    ADD CONSTRAINT FK_BIRTHCERTIFICATE_ON_REGISTRATION_AUTHORITY FOREIGN KEY (`registration_authority`) REFERENCES `organisation` (`id`);

