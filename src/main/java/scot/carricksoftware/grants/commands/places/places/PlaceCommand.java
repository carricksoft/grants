/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.places;


import scot.carricksoftware.grants.domains.places.Region;

public interface PlaceCommand {

    @SuppressWarnings("unused")
    Long getId();

    @SuppressWarnings("unused")
    void setId(Long id);

    @SuppressWarnings("unused")
    String getName();

    @SuppressWarnings("unused")
    void setName(String name);

    Region getRegion();

    void setRegion(Region region);
}
