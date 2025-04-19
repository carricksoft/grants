/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants;import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.enums.census.CensusBoundaryType;

import java.util.Random;

@SuppressWarnings("unused")
@Component
public class GenerateCensusRandomEnums {

    public static CensusBoundaryType GetRandomCensusBoundaryType() {

        CensusBoundaryType[] boundaryTypes = CensusBoundaryType.values();

        Random random = new Random();
        int randomInt = random.nextInt(0, boundaryTypes.length );
        return boundaryTypes[randomInt];
    }


}
