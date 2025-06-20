/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class CapitaliseStringImpl implements CapitaliseString {

    private static final Logger logger = LogManager.getLogger(CapitaliseStringImpl.class);

    @SuppressWarnings("DuplicatedCode")
    @Override
    public String capitalise(String input) {
        logger.info("CapitaliseStringImpl::capitalise");
        if (input == null) {
            return "";
        } else if (input.length() < 3) {
            return input;
        } else {
            logger.debug("CapitalisationImpl::getCapitalisation");
            String[] parts = input.split(" ");
            StringBuilder result = new StringBuilder();
            for (String part : parts) {
                result.append(doPart(part)).append(" ");
            }
            result = new StringBuilder(result.toString().trim());
            parts = result.toString().split("-");
            if (parts.length > 1) {
                result = new StringBuilder();
                for (String part : parts) {
                    if (!result.isEmpty()) {
                        result = new StringBuilder(result.append("-"));
                    }
                    result.append(doPart(part));
                }
            }

            return result.toString();
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private String doPart(String input) {
        String result = input;
        if (input.length() >= 3) {
            String work = input.toLowerCase(Locale.ENGLISH);
            result = work.substring(0, 1).toUpperCase(Locale.ENGLISH) + work.substring(1);
            String prefix = result.substring(0, 2);
            String name = result.substring(2);
            if (prefix.equals("Mc")) {
                result = prefix + doPart(name);
            } else {
                prefix = result.substring(0, 3);
                if (prefix.equals("Mac")) {
                    result = prefix + input.charAt(3) + result.substring(4);
                }
            }
        }
        return result;
    }
}
