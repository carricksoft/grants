/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class TextAttributeConstants {

    private TextAttributeConstants() {
        // to stop checkstyle complaining
    }

    public static final String DOCUMENT_TEXTS = "documentTexts";
    public static final String DOCUMENT_TEXT_COMMAND = "documentTextCommand";

    public static final String APPENDIX_TEXTS = "appendixTexts";
    public static final String APPENDIX_TEXT_COMMAND = "appendixTextCommand";

    public static final String PERSON_TEXTS = "personTexts";
    public static final String PERSON_TEXT_COMMAND = "personTextCommand";
    public static final String PLACE_TEXTS = "placeTexts";
    public static final String PLACE_TEXT_COMMAND = "placeTextCommand";

    @SuppressWarnings("unused")
    public static final String PERSON_IMAGES = "personImages";
    @SuppressWarnings({"unused"})
    public static final String PERSON_IMAGE_COMMAND = "personImageCommand";


    @SuppressWarnings("unused")
    public static final String PLACE_IMAGES = "placeImages";
    @SuppressWarnings({"unused"})
    public static final String PLACE_IMAGE_COMMAND = "placeImageCommand";






}




