/*
 * Copyright (c) Andrew Grant of Carrick Software 29/03/2025, 13:08. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.text.appendixtext;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import scot.carricksoftware.grants.commands.text.AppendixTextCommandImpl;
import scot.carricksoftware.grants.constants.MappingConstants;
import scot.carricksoftware.grants.constants.TextAttributeConstants;
import scot.carricksoftware.grants.constants.TextMappingConstants;
import scot.carricksoftware.grants.constants.ViewConstants;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextCommandConverterImpl;
import scot.carricksoftware.grants.converters.text.appendixtext.AppendixTextConverterImpl;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;

import scot.carricksoftware.grants.services.text.appendixtext.AppendixTextService;
import scot.carricksoftware.grants.validators.text.AppendixTextCommandValidatorImpl;

@Controller
public class AppendixTextFormControllerImpl implements AppendixTextFormController {

    private static final Logger logger = LogManager.getLogger(AppendixTextFormControllerImpl.class);
    private final AppendixTextService appendixTextService;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final AppendixTextCommandConverterImpl appendixTextCommandConverter;
    private final AppendixTextConverterImpl appendixTextConverter;
    private final AppendixTextCommandValidatorImpl appendixTextCommandValidatorImpl;


    public AppendixTextFormControllerImpl(AppendixTextService appendixTextService,
                                          AppendixTextCommandConverterImpl appendixTextCommandConverter,
                                          AppendixTextConverterImpl appendixTextConverter,
                                          AppendixTextCommandValidatorImpl appendixTextCommandValidatorImpl) {
        this.appendixTextService = appendixTextService;
        this.appendixTextCommandConverter = appendixTextCommandConverter;


        this.appendixTextConverter = appendixTextConverter;
        this.appendixTextCommandValidatorImpl = appendixTextCommandValidatorImpl;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_NEW)
    public final String getNewAppendixText(final Model model) {
        logger.debug("AppendixTextFormControllerImpl::getNewAppendixText");
        model.addAttribute(TextAttributeConstants.APPENDIX_TEXT_COMMAND, new AppendixTextCommandImpl());
        return ViewConstants.APPENDIX_TEXT_FORM;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_EDIT)
    public final String appendixTextEdit(@Valid @PathVariable final String id, Model model) {
        logger.debug("AppendixTextFormControllerImpl::appendixTextEdit");
        model.addAttribute(TextAttributeConstants.APPENDIX_TEXT_COMMAND, appendixTextService.findById(Long.valueOf(id)));
        return ViewConstants.APPENDIX_TEXT_FORM;
    }


    @Override
    @PostMapping(TextMappingConstants.APPENDIX_TEXT)
    public String saveOrUpdate(@Valid @ModelAttribute AppendixTextCommand appendixTextCommand, BindingResult bindingResult, Model model) {
        logger.debug("AppendixTextFormControllerImpl::saveOrUpdate");

        appendixTextCommandValidatorImpl.validate(appendixTextCommand, bindingResult);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> logger.debug(error.getDefaultMessage()));
            return ViewConstants.APPENDIX_TEXT_FORM;
        }

        AppendixTextCommand savedCommand = appendixTextService.saveAppendixTextCommand(appendixTextCommand);
        model.addAttribute(TextAttributeConstants.APPENDIX_TEXT_COMMAND, savedCommand);
        return MappingConstants.REDIRECT + TextMappingConstants.APPENDIX_TEXT_SHOW.replace("{id}", "" + savedCommand.getId());
    }



    @SuppressWarnings("SameReturnValue")
    @GetMapping(TextMappingConstants.APPENDIX_TEXT_SHOW)
    public String showById(@PathVariable String id, Model model) {
        logger.debug("AppendixTextFormControllerImpl::showById");
        AppendixTextCommand convertedCommand =  appendixTextConverter.convert(appendixTextService.findById(Long.valueOf(id)));
        model.addAttribute(TextAttributeConstants.APPENDIX_TEXT_COMMAND, convertedCommand);
        return ViewConstants.APPENDIX_TEXT_FORM;
    }


}
