/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.organisations;


import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.domains.places.Organisation;

@Component
public interface OrganisationCommandConverter extends Converter<OrganisationCommand, Organisation> {

    @Override
    Organisation convert(@SuppressWarnings("NullableProblems") @NotNull OrganisationCommand source);


}
