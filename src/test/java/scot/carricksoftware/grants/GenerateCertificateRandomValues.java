/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;

import java.util.Random;

@SuppressWarnings("unused")
@Component
public class GenerateCertificateRandomValues {

    private static final Random rand = new Random();
    @SuppressWarnings("SpellCheckingInspection")
    private static final String[] names = {"Ryland", "Oscar", "Martha", "Brynn"
            , "Euan", "Jack", "Ramsay", "Ally"};


    public static String GetRandomString() {
        int random = rand.nextInt(names.length);
        return names[random];
    }


}
