/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:58. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.people.Person;

public interface PersonImageCommand {
    Long getId();

    void setId(Long id);

    Person getPerson();

    void setPerson(Person person);

    Image getImage();

    void setImage(Image image);

    String getLevel();

    void setLevel(String level);

    String getOrder();

    void setOrder(String order);

    String getCaption();

    void setCaption(String caption);

    String getHeight();

    void setHeight(String height);

    String getWidth();

    void setWidth(String width);
}
