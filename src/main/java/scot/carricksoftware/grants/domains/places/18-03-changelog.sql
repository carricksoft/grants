/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1763502408162-1
CREATE TABLE document_image
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    image_id BIGINT                NULL,
    level    VARCHAR(255)          NULL,
    `order`  VARCHAR(255)          NULL,
    caption  VARCHAR(255)          NULL,
    height   VARCHAR(255)          NULL,
    width    VARCHAR(255)          NULL,
    CONSTRAINT pk_document_image PRIMARY KEY (id)
);

-- changeset apg:1763502408162-2
ALTER TABLE document_image
    ADD CONSTRAINT FK_DOCUMENT_IMAGE_ON_IMAGE FOREIGN KEY (image_id) REFERENCES image (id);

