/*
 * Copyright (c)  08 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.constants;

import org.springframework.stereotype.Component;

@Component
public class ImageMappingConstants {

    private ImageMappingConstants() {
        // to stop checkstyle complaining
    }

    
    public static final String IMAGE_LIST = "/images";
    public static final String IMAGE_NEXT = "/images/next";
    public static final String IMAGE_PREVIOUS = "/images/prev";
    public static final String IMAGE_REWIND = "/images/rewind";
    public static final String IMAGE_FF = "/images/ff";
    public static final String IMAGE_NEW = "/image/new";
    public static final String IMAGE = "/image";
    public static final String IMAGE_SHOW = "/image/{id}/show";
    public static final String IMAGE_DELETE = "/image/{id}/delete";
    public static final String IMAGE_EDIT = "image/{id}/edit";
    
    public static final String PERSON_IMAGE_LIST = "/personImages";
    public static final String PERSON_IMAGE_NEXT = "/personImages/next";
    public static final String PERSON_IMAGE_PREVIOUS = "/personImages/prev";
    public static final String PERSON_IMAGE_REWIND = "/personImages/rewind";
    public static final String PERSON_IMAGE_FF = "/personImages/ff";
    public static final String PERSON_IMAGE_NEW = "/personImage/new";
    public static final String PERSON_IMAGE = "/personImage";
    public static final String PERSON_IMAGE_SHOW = "/personImage/{id}/show";
    public static final String PERSON_IMAGE_DELETE = "/personImage/{id}/delete";
    public static final String PERSON_IMAGE_EDIT = "personImage/{id}/edit";
    
    public static final String PLACE_IMAGE_LIST = "/placeImages";
    public static final String PLACE_IMAGE_NEXT = "/placeImages/next";
    public static final String PLACE_IMAGE_PREVIOUS = "/placeImages/prev";
    public static final String PLACE_IMAGE_REWIND = "/placeImages/rewind";
    public static final String PLACE_IMAGE_FF = "/placeImages/ff";
    public static final String PLACE_IMAGE_NEW = "/placeImage/new";
    public static final String PLACE_IMAGE = "/placeImage";
    public static final String PLACE_IMAGE_SHOW = "/placeImage/{id}/show";
    public static final String PLACE_IMAGE_DELETE = "/placeImage/{id}/delete";
    public static final String PLACE_IMAGE_EDIT = "placeImage/{id}/edit";


    public static final String APPENDIX_IMAGE_LIST = "/appendixImages";
    public static final String APPENDIX_IMAGE_NEXT = "/appendixImages/next";
    public static final String APPENDIX_IMAGE_PREVIOUS = "/appendixImages/prev";
    public static final String APPENDIX_IMAGE_REWIND = "/appendixImages/rewind";
    public static final String APPENDIX_IMAGE_FF = "/appendixImages/ff";
    public static final String APPENDIX_IMAGE_NEW = "/appendixImage/new";
    public static final String APPENDIX_IMAGE = "/appendixImage";
    public static final String APPENDIX_IMAGE_SHOW = "/appendixImage/{id}/show";
    public static final String APPENDIX_IMAGE_DELETE = "/appendixImage/{id}/delete";
    public static final String APPENDIX_IMAGE_EDIT = "appendixImage/{id}/edit";
}






