/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:59. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.springframework.stereotype.Component;

@Component
public class ImageCommandImpl implements ImageCommand{

    Long Id;
    private String name;
    private byte[] imageData;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
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
    public byte[] getImageData() {
        return imageData;
    }

    @Override
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
