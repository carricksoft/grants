/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CapitaliseStringImpl implements CapitaliseString {

    private static final Logger logger = LogManager.getLogger(CapitaliseStringImpl.class);

    @Override
    public String capitalise(String input) {
        logger.debug("CapitaliseStringImpl::capitalise");
        StringBuilder result = new StringBuilder();
        boolean newWord = true;
        if (input != null && input.length() > 2) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (newWord) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(c);
                }

                newWord = characterInSeparators(c);

                if (result.toString().endsWith("Mc")) {
                    newWord = true;
                }
            }
            return result.toString();
        } else {
            return Objects.requireNonNullElse(input, "");
        }
    }


    private boolean characterInSeparators(char c) {
        return c == ' ' || c == '-';
    }
}
