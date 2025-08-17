/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import scot.carricksoftware.grants.domains.people.Person;

import java.util.List;

public interface BMDCache {

    @SuppressWarnings("UnusedReturnValue")
    List<Person> getPeople();
    void invalidatePeople();

}
