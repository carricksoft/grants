/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.converters.images;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class ConvertToBase64Impl implements ConvertToBase64 {

    @Override
    public String convert(byte[] byteData) {
        return Base64.getMimeEncoder().encodeToString(byteData);
    }
}
