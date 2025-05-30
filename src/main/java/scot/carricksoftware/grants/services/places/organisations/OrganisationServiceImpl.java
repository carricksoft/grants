/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 20:23. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.places.organisations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scot.carricksoftware.grants.commands.places.organisations.OrganisationCommand;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationCommandConverter;
import scot.carricksoftware.grants.converters.places.organisations.OrganisationConverter;
import scot.carricksoftware.grants.domains.places.Organisation;
import scot.carricksoftware.grants.repositories.places.OrganisationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    private static final Logger logger = LogManager.getLogger(OrganisationServiceImpl.class);

    @SuppressWarnings({"unused"})
    private final OrganisationRepository organisationRepository;
    private final OrganisationConverter organisationConverter;
    private final OrganisationCommandConverter organisationCommandConverter;

    public OrganisationServiceImpl(
            OrganisationRepository organisationRepository,
            OrganisationConverter organisationConverter,
            OrganisationCommandConverter organisationCommandConverter) {

        this.organisationRepository = organisationRepository;
        this.organisationConverter = organisationConverter;
        this.organisationCommandConverter = organisationCommandConverter;
    }


    @Override
    public void deleteById(Long id) {
        logger.debug("OrganisationServiceImpl::deleteBy");
        organisationRepository.deleteById(id);
    }


    @Override
    public List<Organisation> getPagedOrganisations(int pageNumber) {
        logger.debug("OrganisationServiceImpl::getPagedOrganisation");
        Pageable paging = PageRequest.of(pageNumber, ApplicationConstants.DEFAULT_PAGE_SIZE, getSort());
        Page<Organisation> pagedResult = organisationRepository.findAll(paging);
        return pagedResult.getContent();
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.ASC, "name");
    }

    @Override
    public long count() {
        logger.debug("OrganisationServiceImpl::count");
        return organisationRepository.count();
    }

    @Transactional
    @Override
    public OrganisationCommand saveOrganisationCommand(OrganisationCommand organisationCommand) {
        logger.debug("OrganisationServiceImpl::saveOrganisationCommand");
        Organisation organisation = organisationCommandConverter.convert(organisationCommand);
        Organisation savedOrganisation = organisationRepository.save(organisation);
        assert organisation != null;
        return organisationConverter.convert(savedOrganisation);

    }

    @Override
    public List<Organisation> findAll() {
        logger.debug("OrganisationServiceImpl::findAll");
        List<Organisation> result = new ArrayList<>();
        Iterable<Organisation> organisationIterable = organisationRepository.findAll();
        organisationIterable.forEach(result::add);
        return result;
    }

}
