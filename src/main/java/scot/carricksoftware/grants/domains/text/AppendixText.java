/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.domains.text;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class AppendixText extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`level`")
    private Long level;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`order`")
    private Long order;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`heading`")
    private String heading;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`content`")
    @Lob
    private String content;

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
