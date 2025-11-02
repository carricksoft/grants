/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql


-- changeset apg:1762051389852-2
ALTER TABLE appendix_image
    ADD CONSTRAINT FK_APPENDIXIMAGE_ON_IMAGE FOREIGN KEY (image_id) REFERENCES image (id);

