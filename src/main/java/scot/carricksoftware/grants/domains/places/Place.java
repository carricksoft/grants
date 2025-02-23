/*
 * Copyright (c)  02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.domains.places;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.census.Census;

import java.util.Set;

@SuppressWarnings("DuplicatedCode")
@Entity
public class Place extends BaseEntity {

    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @OneToMany
    @JoinColumn(name = "place_id")
    private Set<Census> censuses;

    public Place() {
        //
        // empty constructor required by JPA
        //
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public Country getCountry() {
        return country;
    }

    @SuppressWarnings("unused")
    public void setCountry(Country country) {
        this.country = country;
    }

    @SuppressWarnings("unused")
    public Region getRegion() {
        return region;
    }

    @SuppressWarnings("unused")
    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Census> getCensuses() {
        return censuses;
    }

    public void setCensuses(Set<Census> censuses) {
        this.censuses = censuses;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (name != null) {
            builder.append(name);
        }
        if (region != null) {
            builder.append(", ");
            builder.append(region.getName());
        }
        if (country != null) {
            builder.append(", ");
            builder.append(country.getName());
        }
        return builder.toString();
    }
}
