/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:10. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.appendixtext;


import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.domains.text.AppendixText;

@Component
public class AppendixTextCommandConverterImpl implements AppendixTextCommandConverter {

    private static final Logger logger = LogManager.getLogger(AppendixTextCommandConverterImpl.class);

    @Override
    public AppendixText convert(@NotNull AppendixTextCommand source) {
        logger.debug("AppendixTextCommandConverter::convert");
        AppendixText target = new AppendixText();
        target.setId(source.getId());
        target.setContent(source.getContent());
        target.setLevel(source.getLevel());
        target.setOrder(source.getOrder());
        target.setHeading(source.getHeading());
        return target;
    }

}
