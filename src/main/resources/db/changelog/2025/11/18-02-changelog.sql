/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1763502561268-2
ALTER TABLE document_image
    ADD CONSTRAINT FK_DOCUMENT_IMAGE_ON_IMAGE FOREIGN KEY (image_id) REFERENCES image (id);

