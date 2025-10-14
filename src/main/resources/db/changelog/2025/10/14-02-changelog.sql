/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql


-- changeset apg:1760427435610-7
ALTER TABLE person_image
    ADD CONSTRAINT FK_PERSONIMAGE_ON_IMAGE FOREIGN KEY (image_id) REFERENCES image (id);

