/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grants.constants.ApplicationConstants;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.CensusEntrySex;

@Entity
public class BirthCertificate extends BaseCertificate {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`new_born_id`")
    private Person newBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name= "`when_born`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`where_born`")
    private String whereBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`sex`")
    private CensusEntrySex sex;

    public Person getNewBorn() {
        return newBorn;
    }

    public void setNewBorn(Person newBorn) {
        this.newBorn = newBorn;
    }

    public String getWhenBorn() {
        return whenBorn;
    }

    public void setWhenBorn(String whenBorn) {
        this.whenBorn = whenBorn;
    }

    public String getWhereBorn() {
        return whereBorn;
    }

    public void setWhereBorn(String whereBorn) {
        this.whereBorn = whereBorn;
    }

    public CensusEntrySex getSex() {
        return sex;
    }

    public void setSex(CensusEntrySex sex) {
        this.sex = sex;
    }
}
