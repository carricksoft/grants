/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.places.Place;

import java.time.LocalDate;


@Entity
public class Census extends BaseEntity {

    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @ManyToOne
    @JoinColumn(name = "census_id")
    Place place;

    @SuppressWarnings("unused")
    LocalDate date;

    @SuppressWarnings("unused")
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @SuppressWarnings("unused")
    public LocalDate getDate() {
        return date;
    }

    @SuppressWarnings("unused")
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
