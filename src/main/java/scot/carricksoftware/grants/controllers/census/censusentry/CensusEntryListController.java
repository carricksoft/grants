/*
 * Copyright (c) Andrew Grant of Carrick Software 21/03/2025, 00:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.census.censusentry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@SuppressWarnings("unused")
@Controller
public interface CensusEntryListController {

    String getListPage(final Model model);

    String getNextPage(final Model model);

    String getPreviousPage(final Model model);

    String getFirstPage(final Model model);

    String getLastPage(final Model model);

    String censusEntryDelete(@PathVariable String id);

    int getPageNumber();
}
