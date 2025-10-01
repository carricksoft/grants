/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.images;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import scot.carricksoftware.grants.BaseEntity;


@Entity
public class Image extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`name`")
    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name= "`file_name`")
    private String fileName;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Lob
    @Column(name = "`imageData`")
    private String imageData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
