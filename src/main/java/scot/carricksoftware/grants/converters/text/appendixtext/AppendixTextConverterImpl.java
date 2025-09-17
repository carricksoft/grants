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
import scot.carricksoftware.grants.commands.text.AppendixTextCommandImpl;
import scot.carricksoftware.grants.domains.text.AppendixText;

@Component
public class AppendixTextConverterImpl implements AppendixTextConverter {

    private static final Logger logger = LogManager.getLogger(AppendixTextConverterImpl.class);

    @Override
    public AppendixTextCommand convert(@NotNull AppendixText source) {
        logger.debug("AppendixTextCommandConverter::convert");
        AppendixTextCommand target = new AppendixTextCommandImpl();
        target.setLevel(source.getLevel());
        target.setOrder(source.getOrder());
        target.setHeading(source.getHeading());
        target.setContent(source.getContent());
        target.setId(source.getId());
        return target;
    }


}
