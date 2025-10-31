/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 11:02. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.images;

import org.springframework.data.repository.PagingAndSortingRepository;
import scot.carricksoftware.grants.domains.images.AppendixImage;

import java.util.Optional;

public interface AppendixImageRepository extends PagingAndSortingRepository<AppendixImage, Long> {

    AppendixImage save(AppendixImage image);

    long count();

    void deleteById(Long id);

    Optional<AppendixImage> findById(Long id);

    Iterable<AppendixImage> findAll();
}
