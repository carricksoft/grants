/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:00. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.Census;

public class CensusEntryCommandImpl implements CensusEntryCommand {

    Long id;

    String name;

    private Census census;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Census getCensus() {
        return census;
    }

    @Override
    public void setCensus(Census census) {
        this.census = census;
    }
}
