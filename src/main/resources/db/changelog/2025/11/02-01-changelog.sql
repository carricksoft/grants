/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1762051389852-1
CREATE TABLE appendix_image
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    image_id BIGINT                NULL,
    level    VARCHAR(255)          NULL,
    `order`  VARCHAR(255)          NULL,
    caption  VARCHAR(255)          NULL,
    height   VARCHAR(255)          NULL,
    width    VARCHAR(255)          NULL,
    CONSTRAINT pk_appendiximage PRIMARY KEY (id)
);
