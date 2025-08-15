/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.controllers;

import org.springframework.ui.Model;

public interface AddAttributes {
    void AddDeathCertificate(Model model);
    void AddMarriageCertificate(Model model);
    void AddBirthCertificate(Model model);
}
