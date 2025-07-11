/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class GenerateRandomNumberValues {

    private static final Random rand = new Random();

    public static Long GetRandomLong() {
        return rand.nextLong();
    }


}
