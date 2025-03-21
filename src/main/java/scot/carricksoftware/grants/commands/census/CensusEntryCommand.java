/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:13. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.Census;

public interface CensusEntryCommand {

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    Census getCensus();

    void setCensus(Census census);
}
