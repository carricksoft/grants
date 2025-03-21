/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:00. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.CensusEntry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CensusCommandImpl implements CensusCommand {

    private Long id;

    private LocalDate date;

    private List<CensusEntry> censusEntries = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public List<CensusEntry> getCensusEntries() {
        return censusEntries;
    }

    @Override
    public void setCensusEntries(List<CensusEntry> censusEntries) {
        this.censusEntries = censusEntries;
    }
}
