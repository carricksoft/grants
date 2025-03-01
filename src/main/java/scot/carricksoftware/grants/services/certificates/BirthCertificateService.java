/*
 * Copyright (c)  28 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.services.certificates;



import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import java.util.List;

public interface BirthCertificateService {

    @SuppressWarnings("unused")
    BirthCertificate findById(Long id);

    @SuppressWarnings("unused")
    BirthCertificate save(BirthCertificate birthCertificate);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<BirthCertificate> getPagedCertificates(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    BirthCertificateCommand saveBirthCertificateCommand(BirthCertificateCommand birthCertificateCommand);

    @SuppressWarnings("unused")
    List<BirthCertificate> findAll();

}
