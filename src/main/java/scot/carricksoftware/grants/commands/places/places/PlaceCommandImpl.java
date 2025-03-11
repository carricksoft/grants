/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.places;

import jakarta.validation.constraints.Size;

@SuppressWarnings("unused")
public class PlaceCommandImpl implements PlaceCommand {
    private Long id;

    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters.")
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


}
