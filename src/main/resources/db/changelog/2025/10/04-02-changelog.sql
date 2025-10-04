/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql



-- changeset apg:1759570040134-2
ALTER TABLE person
    ADD CONSTRAINT FK_PERSON_ON_IMAGE FOREIGN KEY (image_id) REFERENCES image (id);

