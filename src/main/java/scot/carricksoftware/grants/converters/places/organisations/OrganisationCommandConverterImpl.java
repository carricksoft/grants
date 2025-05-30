/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.organisations;


import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.domains.places.Organisation;

@Component
public class OrganisationCommandConverterImpl implements OrganisationCommandConverter {

    @Override
    public Organisation convert(@NotNull OrganisationCommand source) {
        Organisation target = new Organisation();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }


}
