/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.people.Person;

import java.util.Random;

@Component
public class GenerateRandomValues {

    private static final Random rand = new Random();
    @SuppressWarnings("SpellCheckingInspection")
    private static final String[] names = {"Ryland", "Oscar", "Martha", "Brynn"
            , "Euan", "Jack", "Ramsay", "Ally"};

    public static Long GetRandomLong() {
        return rand.nextLong();
    }

    @SuppressWarnings("unused")
    public static Integer GetRandomInt() {
        return rand.nextInt();
    }

    public static String GetRandomString() {
        int random = rand.nextInt(names.length);
        return names[random];
    }

    public static Person GetRandomPerson() {
        Person person = new Person();
        person.setFirstName(GetRandomString());
        person.setLastName(GetRandomString());
        return person;
    }

}
