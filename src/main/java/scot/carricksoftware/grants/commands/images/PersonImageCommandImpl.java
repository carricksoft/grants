/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 09:59. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.domains.images.Image;
import scot.carricksoftware.grants.domains.people.Person;

@Component
public class PersonImageCommandImpl implements PersonImageCommand{

    private Long Id;
    private Person person;
    private Image image;
    private String level;
    private String order;
    private String caption;
    private String height;
    private String width;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String getOrder() {
        return order;
    }

    @Override
    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String getHeight() {
        return height;
    }

    @Override
    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String getWidth() {
        return width;
    }

    @Override
    public void setWidth(String width) {
        this.width = width;
    }
}
