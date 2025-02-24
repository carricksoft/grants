/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.Set;


@Entity
public class Census extends BaseEntity {

    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    Place place;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToMany
    @JoinColumn(name = "census_id")
    private Set<Census> censuses;

    @DateTimeFormat(pattern = "dd MMM yyyy")
    String date;

    @SuppressWarnings("unused")
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @SuppressWarnings("unused")
    public String getDate() {
        return date;
    }

    @SuppressWarnings("unused")
    public void setDate(String date) {
        this.date = date;
    }

    @SuppressWarnings("unused")
    public Set<Census> getCensuses() {
        return censuses;
    }

    @SuppressWarnings("unused")
    public void setCensuses(Set<Census> censuses) {
        this.censuses = censuses;
    }

    @Override
    public String toString() {
        return place.getName() + ", " + date;
    }
}
