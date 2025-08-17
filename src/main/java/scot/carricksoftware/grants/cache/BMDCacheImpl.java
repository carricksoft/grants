/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.cache;

import scot.carricksoftware.grants.domains.people.Person;

import java.util.List;

public class BMDCacheImpl implements BMDCache {

    @Override
    public List<Person> getPeople() {
        return List.of();
    }

    @Override
    public void invalidatePeople() {
        throw new UnsupportedOperationException("BMDCache::invalidatePeople Not supported yet.");
    }
}
