/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.places.Place;

import java.util.Set;


@Entity
public class Census extends BaseEntity {

    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
    Place place;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToMany
    @JoinColumn(name = "census_id")
    private Set<CensusEntry> censusEntries;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
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


    public Set<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    public void setCensusEntries(Set<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    @Override
    public String toString() {
        return place.getName() + ", " + date;
    }


}
