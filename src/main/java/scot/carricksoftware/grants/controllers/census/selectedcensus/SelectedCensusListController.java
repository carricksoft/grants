/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.selectedcensus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@SuppressWarnings("unused")
@Controller
public interface SelectedCensusListController {

    String getListPage(final Model model);

    String getNextPage(final Model model);

    String getPreviousPage(final Model model);

    String getFirstPage(final Model model);

    String getLastPage(final Model model);

    int getPageNumber();
}
