/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;

@Component
public class GenerateRandomValues {

    public static Long GetRandomLong() {
        long lowLimit = 1L;
        return lowLimit + (long) (Math.random() * lowLimit);
    }
}
