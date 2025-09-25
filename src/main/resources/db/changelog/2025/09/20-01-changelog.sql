/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1758399661903-5
CREATE TABLE appendix_text
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    level   VARCHAR(255)          NULL,
    `order` VARCHAR(255)          NULL,
    heading VARCHAR(255)          NULL,
    content LONGTEXT              NULL,
    CONSTRAINT pk_appendixtext PRIMARY KEY (id)
);


