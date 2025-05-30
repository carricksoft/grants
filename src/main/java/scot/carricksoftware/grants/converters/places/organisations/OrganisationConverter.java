/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 18:55. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.places.organisations;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.domains.places.Organisation;

@SuppressWarnings("unused")
@Component
public interface OrganisationConverter extends Converter<Organisation, OrganisationCommand> {

    @SuppressWarnings("NullableProblems")
    OrganisationCommand convert(Organisation source);
}
