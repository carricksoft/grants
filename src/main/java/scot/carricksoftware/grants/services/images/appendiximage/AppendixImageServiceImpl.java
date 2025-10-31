/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.images.appendiximage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.images.AppendixImageCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageCommandConverterImpl;
import scot.carricksoftware.grants.converters.images.appendiximage.AppendixImageConverterImpl;
import scot.carricksoftware.grants.domains.images.AppendixImage;
import scot.carricksoftware.grants.repositories.images.AppendixImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppendixImageServiceImpl implements AppendixImageService {
    private static final Logger logger = LogManager.getLogger(AppendixImageServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final AppendixImageRepository appendixImageRepository;
    private final AppendixImageConverterImpl appendixImageConverterImpl;
    private final AppendixImageCommandConverterImpl appendixImageCommandConverterImpl;

    public AppendixImageServiceImpl(
            AppendixImageRepository appendixImageRepository,
            AppendixImageConverterImpl appendixImageConverterImpl,
            AppendixImageCommandConverterImpl appendixImageCommandConverterImpl) {

        this.appendixImageRepository = appendixImageRepository;
        this.appendixImageConverterImpl = appendixImageConverterImpl;
        this.appendixImageCommandConverterImpl = appendixImageCommandConverterImpl;
    }


    @Override
    public AppendixImage findById(Long id) {
        logger.debug("AppendixImageServiceImpl::findById");
        Optional<AppendixImage> appendixImageOptional = appendixImageRepository.findById(id);
        return appendixImageOptional.orElse(null);
    }

    @Override
    public AppendixImage save(AppendixImage appendixImage) {
        logger.debug("AppendixImageServiceImpl::save");
        return appendixImageRepository.save(appendixImage);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("AppendixImageServiceImpl::deleteBy");
        appendixImageRepository.deleteById(id);
    }
    
    
    @Override
    public List<AppendixImage> getPagedAppendixImages(int pageNumber) {
        logger.debug("AppendixImageServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<AppendixImage> pagedResult = appendixImageRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("AppendixImageServiceImpl::count");
        return appendixImageRepository.count();
    }

    @Transactional
    @Override
    public AppendixImageCommand saveAppendixImageCommand(AppendixImageCommand appendixImageCommand) {
        logger.debug("AppendixImageServiceImpl::saveAppendixImageCommand");
        AppendixImage appendixImage = appendixImageCommandConverterImpl.convert(appendixImageCommand);
        AppendixImage savedAppendixImage = appendixImageRepository.save(appendixImage);
        return appendixImageConverterImpl.convert(savedAppendixImage);

    }

    @Override
    public List<AppendixImage> findAll() {
        logger.debug("AppendixImageServiceImpl::findAll");
        List<AppendixImage> result = new ArrayList<>();
        Iterable<AppendixImage> appendixImageIterable = appendixImageRepository.findAll();
        appendixImageIterable.forEach(result::add);
        return result;
    }

}
