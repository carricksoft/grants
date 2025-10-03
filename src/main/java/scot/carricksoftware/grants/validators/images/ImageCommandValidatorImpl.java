/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 09:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.validators.images;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import scot.carricksoftware.grants.commands.images.ImageCommand;
import scot.carricksoftware.grants.constants.ValidationConstants;
import scot.carricksoftware.grants.validators.helpers.ValidateTypes;

@SuppressWarnings("unused")
@Component
public class ImageCommandValidatorImpl implements ImageCommandValidator {

    private static final Logger logger = LogManager.getLogger(ImageCommandValidatorImpl.class);

    private final ValidateTypes validateTypes;

    public ImageCommandValidatorImpl(ValidateTypes validateTypes) {
        this.validateTypes = validateTypes;
    }

    @Override
    public void validate(ImageCommand imageCommand, BindingResult bindingResult) {
      logger.debug("ImageCommandValidator::validate");
      validateName(imageCommand, bindingResult);
      validateImageData(imageCommand, bindingResult);
      validateFileType(imageCommand, bindingResult);
      var z = bindingResult.getAllErrors();
      var x = -1;
    }

    private void validateFileType(ImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateFileType");
        validateTypes.validateFileType(imageCommand.getFileName(), "fileName", new String[]{"JPG", "GIF"}, ValidationConstants.UNSUPPORTED_FILE_TYPE, bindingResult);
    }

    private void validateName (ImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateName");
        validateTypes.validateNullOrEmptyString(imageCommand.getName(), "name", ValidationConstants.NAME_IS_NULL, bindingResult);
    }

    private void validateImageData(ImageCommand imageCommand, BindingResult bindingResult) {
        logger.debug("ImageCommandValidator::validateImageData");
        validateTypes.validateNullOrEmptyString(imageCommand.getFileName(), "fileName", ValidationConstants.IMAGE_DATA_IS_NULL, bindingResult);
    }

}

