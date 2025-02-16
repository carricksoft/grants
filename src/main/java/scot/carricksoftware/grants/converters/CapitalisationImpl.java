/*
 * Copyright (c)  16 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.converters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CapitalisationImpl implements Capitalisation {

    private static final Logger logger = LogManager.getLogger(CapitalisationImpl.class);

    @Override
    public String getCapitalisation(String input) {
        logger.info("CapitalisationImpl.getCapitalisation");
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
