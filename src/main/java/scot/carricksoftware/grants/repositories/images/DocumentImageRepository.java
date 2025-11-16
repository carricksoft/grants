/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.images;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.images.DocumentImage;

import java.util.Optional;

@Repository
public interface DocumentImageRepository extends PagingAndSortingRepository<DocumentImage, Long> {

    DocumentImage save(DocumentImage image);

    long count();

    void deleteById(Long id);

    Optional<DocumentImage> findById(Long id);

    Iterable<DocumentImage> findAll();
}
