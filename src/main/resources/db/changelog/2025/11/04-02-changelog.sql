/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql


-- changeset apg:1762255362349-2
ALTER TABLE document_text
    ADD content LONGTEXT     NULL,
    ADD heading VARCHAR(255) NULL,
    ADD level   VARCHAR(255) NULL,
    ADD `order` VARCHAR(255) NULL;


