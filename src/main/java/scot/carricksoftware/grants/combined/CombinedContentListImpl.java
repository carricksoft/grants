/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.combined;

import scot.carricksoftware.grants.domains.images.Image;

import java.util.List;

public class CombinedContentListImpl implements CombinedContentList {

    private List<Combined> combinedList;

    @Override
    public void addPersonImage(Image image) {

    }

    @Override
    public void addPersonText(List<Image> images) {

    }

    @Override
    public void sort() {

    }

    @Override
    public List<Combined> getList() {
        return this.combinedList;
    }

    @Override
    public void clear() {

    }


}
