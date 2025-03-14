/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 17:17. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.places.regions;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.places.Country;

@Component
public class RegionCommandImpl implements RegionCommand {

    private Long id;

    private String name;

    private Country country;


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

    @Override
    public Country getCountry() {
        return country;
    }

    @Override
    public void setCountry(Country country) {
        this.country = country;
    }
}
