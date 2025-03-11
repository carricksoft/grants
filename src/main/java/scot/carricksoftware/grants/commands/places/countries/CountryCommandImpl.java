/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:17. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.places.countries;

import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class CountryCommandImpl implements CountryCommand {

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
