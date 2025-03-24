/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.certificates;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.certificates.BirthCertificateCommand;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;

import java.util.List;

@Service
public interface BirthCertificateService {

    @SuppressWarnings("unused")
    BirthCertificate findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    BirthCertificate save(BirthCertificate birthCertificate);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<BirthCertificate> getPagedBirthCertificates(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    BirthCertificateCommand saveBirthCertificateCommand(BirthCertificateCommand birthCertificateCommand);

    @SuppressWarnings("unused")
    List<BirthCertificate> findAll();
}
