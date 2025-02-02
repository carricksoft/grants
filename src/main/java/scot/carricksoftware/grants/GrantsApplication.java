/*
 * Copyright (c) 2025- 02 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrantsApplication {
    private static final Logger logger = LogManager.getLogger(GrantsApplication.class);

    public static void main(String[] args) {
        logger.debug("GrantsApplication started");
        SpringApplication.run(GrantsApplication.class, args);
    }

}
