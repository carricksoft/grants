/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:10. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.documenttext;


import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.DocumentTextCommand;
import scot.carricksoftware.grants.domains.text.DocumentText;

@Component
public class DocumentTextCommandConverterImpl implements DocumentTextCommandConverter {

    private static final Logger logger = LogManager.getLogger(DocumentTextCommandConverterImpl.class);

    @Override
    public DocumentText convert(@NotNull DocumentTextCommand source) {
        logger.debug("DocumentTextCommandConverter::convert");
        DocumentText target = new DocumentText();
        target.setId(source.getId());
        target.setId(source.getId());
        target.setContent(source.getContent());
        target.setLevel(source.getLevel());
        target.setOrder(source.getOrder());
        target.setHeading(source.getHeading());
        return target;
    }


}
