/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

public interface ImageCommand {
    Long getId();

    void setId(Long id);

    @SuppressWarnings("unused")
    String getName();

    @SuppressWarnings("unused")
    void setName(String name);

    @SuppressWarnings("unused")
    String getImageData();

    @SuppressWarnings("unused")
    void setImageData(String imageData);

    String getFileName();

    void setFileName(String filename);
}
