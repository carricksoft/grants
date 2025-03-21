/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import scot.carricksoftware.grants.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Census extends BaseEntity {

    private LocalDate date;

    @OneToMany(mappedBy = "census", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CensusEntry> censusEntries = new ArrayList<>();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    public void setCensusEntries(List<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }

    @Override
    public String toString() {
        return "Census  ?" + date.toString();
    }
}
