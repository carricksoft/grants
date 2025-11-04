/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1762255362349-15
ALTER TABLE place_image
    ADD CONSTRAINT FK_PLACE_IMAGE_ON_IMAGE FOREIGN KEY (image_id) REFERENCES image (id);

