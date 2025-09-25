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
    @Lob
    @Column(name = "`imageData`")
    private byte[] imageData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
