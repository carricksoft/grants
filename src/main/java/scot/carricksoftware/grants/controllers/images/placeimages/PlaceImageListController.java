/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.images.placeimages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@SuppressWarnings("unused")
@Controller
public interface PlaceImageListController {

    String getListPage(final Model model);

    String getNextPage(final Model model);

    String getPreviousPage(final Model model);

    String getFirstPage(final Model model);

    String getLastPage(final Model model);

    String placeImageDelete(@PathVariable String id);

    int getPageNumber();
}
