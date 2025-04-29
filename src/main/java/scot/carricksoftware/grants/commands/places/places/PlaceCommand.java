/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.places;


import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.domains.text.PlaceText;

import java.util.List;

public interface PlaceCommand {

    @SuppressWarnings("unused")
    Long getId();

    @SuppressWarnings("unused")
    void setId(Long id);

    @SuppressWarnings("unused")
    String getName();

    @SuppressWarnings("unused")
    void setName(String name);

    Region getRegion();

    void setRegion(Region region);

    List<Census> getCensuses();

    void setCensuses(List<Census> censuses);

    List<PlaceImage> getPlaceImages();

    void setPlaceImages(List<PlaceImage> placeImages);

    List<PlaceText> getPlaceTexts();

    void setPlaceTexts(List<PlaceText> placeTexts);
}
