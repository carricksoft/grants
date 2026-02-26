/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.appendixtext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverter;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverter;
import scot.carricksoftware.grants.domains.text.AppendixText;
import scot.carricksoftware.grants.repositories.text.AppendixTextRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppendixTextServiceImpl implements AppendixTextService {
    private static final Logger logger = LogManager.getLogger(AppendixTextServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final AppendixTextRepository appendixTextRepository;
    private final AppendixTextConverter appendixTextConverter;
    private final AppendixTextCommandConverter appendixTextCommandConverter;

    public AppendixTextServiceImpl(
            AppendixTextRepository appendixTextRepository,
            AppendixTextConverter appendixTextConverter,
            AppendixTextCommandConverter appendixTextCommandConverter) {

        this.appendixTextRepository = appendixTextRepository;
        this.appendixTextConverter = appendixTextConverter;
        this.appendixTextCommandConverter = appendixTextCommandConverter;
    }


    @Override
    public AppendixText findById(Long id) {
        logger.debug("AppendixTextServiceImpl::findById");
        Optional<AppendixText> appendixTextOptional = appendixTextRepository.findById(id);
        return appendixTextOptional.orElse(null);
    }

    public AppendixText save(AppendixText appendixText) {
        logger.debug("AppendixTextServiceImpl::save");
        return appendixTextRepository.save(appendixText);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("AppendixTextServiceImpl::deleteBy");
        appendixTextRepository.deleteById(id);
    }

    @Override
    public List<AppendixText> getPagedAppendixTexts(int pageNumber) {
        logger.debug("AppendixTextServiceImpl::getPagedCountries");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<AppendixText> pagedResult = appendixTextRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "id");
    }

    @Override
    public long count() {
        logger.debug("AppendixTextServiceImpl::count");
        return appendixTextRepository.count();
    }

    @Transactional
    @Override
    public AppendixTextCommand saveAppendixTextCommand(AppendixTextCommand appendixTextCommand) {
        logger.debug("AppendixTextServiceImpl::saveAppendixTextCommand");
        AppendixText appendixText = appendixTextCommandConverter.convert(appendixTextCommand);
        AppendixText savedAppendixText = appendixTextRepository.save(appendixText);
        return appendixTextConverter.convert(savedAppendixText);

    }

    @Override
    public List<AppendixText> findAll() {
        logger.debug("AppendixTextServiceImpl::findAll");
        List<AppendixText> result = new ArrayList<>();
        Iterable<AppendixText> appendixTextIterable = appendixTextRepository.findAll();
        appendixTextIterable.forEach(result::add);
        return result;
    }

}
