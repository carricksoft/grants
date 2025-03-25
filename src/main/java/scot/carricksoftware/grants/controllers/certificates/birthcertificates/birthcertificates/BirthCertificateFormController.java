/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates.birthcertificates;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;

@SuppressWarnings("unused")

public interface BirthCertificateFormController {

    String saveOrUpdate(@ModelAttribute BirthCertificateCommand countryCommand, BindingResult bindingResult, Model model);
}
