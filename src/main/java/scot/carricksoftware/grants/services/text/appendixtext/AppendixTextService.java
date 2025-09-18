/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 12:33. All rights reserved.
 *
 */

package scot.carricksoftware.grants.services.text.appendixtext;

import org.springframework.stereotype.Service;
import scot.carricksoftware.grants.commands.text.AppendixTextCommand;
import scot.carricksoftware.grants.domains.text.AppendixText;

import java.util.List;


@Service
public interface AppendixTextService {

    @SuppressWarnings("unused")
    AppendixText findById(Long id);

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    AppendixText save(AppendixText appendixText);

    @SuppressWarnings("unused")
    void deleteById(Long id);

    @SuppressWarnings("unused")
    List<AppendixText> getPagedAppendixTexts(int pageNumber);

    @SuppressWarnings("unused")
    long count();

    @SuppressWarnings({"unused", "UnusedReturnValue"})
    AppendixTextCommand saveAppendixTextCommand(AppendixTextCommand appendixTextCommand);

    @SuppressWarnings("unused")
    List<AppendixText> findAll();
}
