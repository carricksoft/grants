/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.regions;

import org.springframework.stereotype.Component;

@Component
public interface RegionCommand {

    Long getId();

    @SuppressWarnings("unused")
    void setId(Long id);

    @SuppressWarnings("unused")
    String getName();

    @SuppressWarnings("unused")
    void setName(String name);
}
