/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.places.places;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.images.PlaceImage;
import scot.carricksoftware.grants.domains.places.Region;
import scot.carricksoftware.grants.domains.text.PlaceText;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PlaceCommandImpl implements PlaceCommand {
    private Long id;

    private Region region;

    private String name;

    private List<Census> censuses = new ArrayList<>();

    private List<PlaceImage> placeImages = new ArrayList<>();

    private List<PlaceText> placeTexts = new ArrayList<>();


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Region getRegion() {
        return region;
    }

    @Override
    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public List<Census> getCensuses() {
        return censuses;
    }

    @Override
    public void setCensuses(List<Census> censuses) {
        this.censuses = censuses;
    }

    @Override
    public List<PlaceImage> getPlaceImages() {
        return placeImages;
    }

    @Override
    public void setPlaceImages(List<PlaceImage> placeImages) {
        this.placeImages = placeImages;
    }

    @Override
    public List<PlaceText> getPlaceTexts() {
        return placeTexts;
    }

    @Override
    public void setPlaceTexts(List<PlaceText> placeTexts) {
        this.placeTexts = placeTexts;
    }
}
