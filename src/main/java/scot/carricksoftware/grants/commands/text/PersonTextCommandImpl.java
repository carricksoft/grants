/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:42. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.text;

import scot.carricksoftware.grants.domains.people.Person;

public class PersonTextCommandImpl implements PersonTextCommand {

    private Long Id;
    private Person person;
    private Long level;
    private Long order;
    private String heading;
    private String content;

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
    public Long getLevel() {
        return level;
    }

    @Override
    public void setLevel(Long level) {
        this.level = level;
    }

    @Override
    public Long getOrder() {
        return order;
    }

    @Override
    public void setOrder(Long order) {
        this.order = order;
    }

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public void setHeading(String heading) {
        this.heading = heading;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
