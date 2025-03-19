/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.Entity;
import scot.carricksoftware.grants.BaseEntity;

import java.time.LocalDate;

@Entity
public class Census extends BaseEntity {

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
