/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class TextMappingConstants {

    private TextMappingConstants() {
        // to stop checkstyle complaining
    }

    public static final String DOCUMENT_TEXT_LIST = "/documentTexts";
    public static final String DOCUMENT_TEXT_NEXT = "/documentTexts/next";
    public static final String DOCUMENT_TEXT_PREVIOUS = "/documentTexts/prev";
    public static final String DOCUMENT_TEXT_REWIND = "/documentTexts/rewind";
    public static final String DOCUMENT_TEXT_FF = "/documentTexts/ff";
    public static final String DOCUMENT_TEXT_NEW = "/documentText/new";
    public static final String DOCUMENT_TEXT = "/documentText";
    public static final String DOCUMENT_TEXT_SHOW = "/documentText/{id}/show";
    public static final String DOCUMENT_TEXT_DELETE = "/documentTexts/{id}/delete";
    public static final String DOCUMENT_TEXT_EDIT = "documentText/{id}/edit";

    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_LIST = "/appendixTexts";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_NEXT = "/appendixTexts/next";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_PREVIOUS = "/appendixTexts/prev";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_REWIND = "/appendixTexts/rewind";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_FF = "/appendixTexts/ff";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_NEW = "/appendixText/new";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT = "/appendixText";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_SHOW = "/appendixText/{id}/show";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_DELETE = "/appendixTexts/{id}/delete";
    @SuppressWarnings({"unused"})
    public static final String APPENDIX_TEXT_EDIT = "appendixText/{id}/edit";


    public static final String PERSON_TEXT_LIST = "/personTexts";
    public static final String PERSON_TEXT_NEXT = "/personTexts/next";
    public static final String PERSON_TEXT_PREVIOUS = "/personTexts/prev";
    public static final String PERSON_TEXT_REWIND = "/personTexts/rewind";
    public static final String PERSON_TEXT_FF = "/personTexts/ff";
    public static final String PERSON_TEXT_NEW = "/personText/new";
    public static final String PERSON_TEXT = "/personText";
    public static final String PERSON_TEXT_SHOW = "/personText/{id}/show";
    public static final String PERSON_TEXT_DELETE = "/personTexts/{id}/delete";
    public static final String PERSON_TEXT_EDIT = "personText/{id}/edit";

    public static final String PLACE_TEXT_LIST = "/placeTexts";
    public static final String PLACE_TEXT_NEXT = "/placeTexts/next";
    public static final String PLACE_TEXT_PREVIOUS = "/placeTexts/previous";
    public static final String PLACE_TEXT_REWIND = "/placeTexts/rewind";
    public static final String PLACE_TEXT_FF = "/placeTexts/ff";
    public static final String PLACE_TEXT_NEW = "/placeText/new";
    public static final String PLACE_TEXT = "/placeText";
    public static final String PLACE_TEXT_SHOW = "/placeText/{id}/show";
    public static final String PLACE_TEXT_DELETE = "/placeTexts/{id}/delete";
    public static final String PLACE_TEXT_EDIT = "placeText/{id}/edit";
    
}






