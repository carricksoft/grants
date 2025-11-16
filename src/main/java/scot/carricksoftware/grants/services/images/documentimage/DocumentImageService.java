/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.documentimage;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.domains.images.DocumentImage;

import java.util.List;


@SuppressWarnings("unused")
@Service
public interface DocumentImageService {

    @SuppressWarnings("unused")
    DocumentImage findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    DocumentImage save(DocumentImage documentImage);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<DocumentImage> getPagedDocumentImages(int pageNumber);

    @SuppressWarnings("unused")
    long count();


    @SuppressWarnings({"unused", "UnusedReturnValue"})
    DocumentImageCommand saveDocumentImageCommand(DocumentImageCommand DocumentImageCommand);

    @SuppressWarnings("unused")
    List<DocumentImage> findAll();
}
