/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

-- liquibase formatted sql

-- changeset apg:1753213932580-1
ALTER TABLE death_certificate
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_REGISTRATION_AUTHORITY FOREIGN KEY (registration_authority) REFERENCES organisation (id),
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_SPOUSE FOREIGN KEY (spouse_id) REFERENCES person (id),
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_USUAL_RESIDENCE FOREIGN KEY (usual_residence_id) REFERENCES place (id),
    ADD CONSTRAINT FK_DEATHCERTIFICATE_ON_WHERE_DIED FOREIGN KEY (where_died_id) REFERENCES place (id);

