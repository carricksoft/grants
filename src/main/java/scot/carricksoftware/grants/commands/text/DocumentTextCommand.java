/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:42. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

public interface DocumentTextCommand {
    Long getId();

    void setId(Long id);

    String getLevel();

    void setLevel(String level);

    String getOrder();

    void setOrder(String order);

    String getHeading();

    void setHeading(String heading);

    String getContent();

    void setContent(String content);
}
