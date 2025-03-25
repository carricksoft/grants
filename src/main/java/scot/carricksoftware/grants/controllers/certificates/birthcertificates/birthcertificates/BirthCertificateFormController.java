/*
 * Copyright (c)  20 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.controllers.certificates.birthcertificates.birthcertificates;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.constants.MappingConstants;

@SuppressWarnings("unused")

public interface BirthCertificateFormController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_NEW)
    String getNewBirthCertificate(Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_EDIT)
    String birthCertificateEdit(@Valid @PathVariable String id, Model model);

    String saveOrUpdate(@ModelAttribute BirthCertificateCommand countryCommand, BindingResult bindingResult, Model model);

    @SuppressWarnings("SameReturnValue")
    @GetMapping(MappingConstants.BIRTHCERTIFICATE_SHOW)
    String showById(@PathVariable String id, Model model);
}
