/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.documentimage;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.images.DocumentImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.documentimage.DocumentImageConverterImpl;
import scot.carricksoftware.grants.domains.images.DocumentImage;
import scot.carricksoftware.grants.repositories.images.DocumentImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentImageServiceImpl implements DocumentImageService {
    private static final Logger logger = LogManager.getLogger(DocumentImageServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final DocumentImageRepository documentImageRepository;
    private final DocumentImageConverterImpl documentImageConverterImpl;
    private final DocumentImageCommandConverterImpl documentImageCommandConverterImpl;

    public DocumentImageServiceImpl(
            DocumentImageRepository documentImageRepository,
            DocumentImageConverterImpl documentImageConverterImpl,
            DocumentImageCommandConverterImpl documentImageCommandConverterImpl) {

        this.documentImageRepository = documentImageRepository;
        this.documentImageConverterImpl = documentImageConverterImpl;
        this.documentImageCommandConverterImpl = documentImageCommandConverterImpl;
    }


    @Override
    public DocumentImage findById(Long id) {
        logger.debug("DocumentImageServiceImpl::findById");
        Optional<DocumentImage> documentImageOptional = documentImageRepository.findById(id);
        return documentImageOptional.orElse(null);
    }

    @Override
    public DocumentImage save(DocumentImage documentImage) {
        logger.debug("DocumentImageServiceImpl::save");
        return documentImageRepository.save(documentImage);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("DocumentImageServiceImpl::deleteBy");
        documentImageRepository.deleteById(id);
    }
    
    
    @Override
    public List<DocumentImage> getPagedDocumentImages(int pageNumber) {
        logger.debug("DocumentImageServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<DocumentImage> pagedResult = documentImageRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("DocumentImageServiceImpl::count");
        return documentImageRepository.count();
    }

    @Transactional
    @Override
    public DocumentImageCommand saveDocumentImageCommand(DocumentImageCommand documentImageCommand) {
        logger.debug("DocumentImageServiceImpl::saveDocumentImageCommand");
        DocumentImage documentImage = documentImageCommandConverterImpl.convert(documentImageCommand);
        DocumentImage savedDocumentImage = documentImageRepository.save(documentImage);
        return documentImageConverterImpl.convert(savedDocumentImage);

    }

    @Override
    public List<DocumentImage> findAll() {
        logger.debug("DocumentImageServiceImpl::findAll");
        List<DocumentImage> result = new ArrayList<>();
        Iterable<DocumentImage> documentImageIterable = documentImageRepository.findAll();
        documentImageIterable.forEach(result::add);
        return result;
    }

}
