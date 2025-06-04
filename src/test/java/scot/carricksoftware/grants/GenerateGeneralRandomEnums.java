/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.enums.certificates.CertificateType;
import scot.carricksoftware.grants.enums.general.YesNo;

import java.util.Random;

@SuppressWarnings("unused")
@Component
public class GenerateGeneralRandomEnums {

    public static YesNo GetRandomGeneralYesNo() {

        YesNo[] yesNoArray = YesNo.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, yesNoArray.length);
        return yesNoArray[randomInt];
    }

    public static CertificateType GetRandomCertificateType() {

        CertificateType[] certificateTypes = CertificateType.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, certificateTypes.length);
        return certificateTypes[randomInt];
    }


}
