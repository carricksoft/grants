/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.appendiximage;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.domains.images.AppendixImage;

import java.util.List;


@SuppressWarnings("unused")
@Service
public interface AppendixImageService {

    @SuppressWarnings("unused")
    AppendixImage findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    AppendixImage save(AppendixImage appendixImage);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<AppendixImage> getPagedAppendixImages(int pageNumber);

    @SuppressWarnings("unused")
    long count();


    @SuppressWarnings("unused")
    AppendixImageCommand saveAppendixImageCommand(AppendixImageCommand AppendixImageCommand);

    @SuppressWarnings("unused")
    List<AppendixImage> findAll();
}
