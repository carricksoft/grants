/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;

import java.util.Random;

import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

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

    public static BirthCertificate GetRandomBirthCertificate() {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setId(GetRandomLong());
        return birthCertificate;
    }

    public static DeathCertificate GetRandomDeathCertificate() {
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificate.setId(GetRandomLong());
        return deathCertificate;
    }


}
