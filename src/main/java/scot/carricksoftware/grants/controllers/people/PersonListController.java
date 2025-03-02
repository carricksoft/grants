/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@SuppressWarnings("unused")
@Controller
public interface PersonListController {

    @SuppressWarnings("unused")
    String getPagedPeople(final Model model, @RequestParam(defaultValue = "0") final int pageNumber);

    String getNextPage(final Model model);

    String getPreviousPage(final Model model);

    String getFirstPage(final Model model);

    String getLastPage(final Model model);

    String personDelete(@PathVariable String id);

    int getPageNumber();
}

