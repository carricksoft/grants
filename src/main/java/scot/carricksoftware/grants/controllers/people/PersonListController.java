/*
 * Copyright (c)  09 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.people;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@SuppressWarnings("unused")
@Controller
public interface PersonListController {

    @SuppressWarnings("unused")
    String getListPage(final Model model, @RequestParam(defaultValue = "0") final int pageNumber);

}
