/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import java.time.LocalDate;

public interface CensusCommand {
    Long getId();

    void setId(Long id);

    LocalDate getDate();

    void setDate(LocalDate date);
}
