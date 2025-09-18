/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 19:47. All rights reserved.
 *
 */

package scot.carricksoftware.grants.repositories.text;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import scot.carricksoftware.grants.domains.text.AppendixText;

import java.util.Optional;


@SuppressWarnings("unused")
@Repository
public interface AppendixTextRepository extends PagingAndSortingRepository<AppendixText, Long> {

    @SuppressWarnings("unused")
    AppendixText save(AppendixText appendixText);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    Optional<AppendixText> findById(Long id);

    @SuppressWarnings("unused")
    Iterable<AppendixText> findAll();
}
