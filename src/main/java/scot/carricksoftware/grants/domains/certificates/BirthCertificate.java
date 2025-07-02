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
import scot.carricksoftware.grants.domains.places.Place;
import scot.carricksoftware.grants.enums.general.Sex;

@Entity
public class BirthCertificate extends BaseCertificate {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`new_born_id`")
    private Person newBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_born`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`where_born_id`")
    private Place whereBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_where_born`")
    private String untrackedWhereBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`sex`")
    private Sex sex;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`father_id`")
    private Person father;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_father`")
    private String untrackedFather;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`father_rank`")
    private String fatherRank;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`mother_id`")
    private Person mother;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`date_and_place_of_marriage`")
    private String dateAndPlaceOfMarriage;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`informant_id`")
    private Person informant;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_informant`")
    private String untrackedInformant;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`informant_qualification`")
    private String informantQualification;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_registered`")
    private String whenRegistered;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`where_registered`")
    private String whereRegistered;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`father_usual_residence_id`")
    private Place fatherUsualResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name="`untracked_father_usual_residence`")
    private String untrackedFatherUsualResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name="`informant_residence`")
    private String informantResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`mother_usual_residence_id`")
    private Place motherUsualResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name="`untracked_mother_usual_residence`")
    private String untrackedMotherUsualResidence;

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

    public Place getWhereBorn() {
        return whereBorn;
    }

    public void setWhereBorn(Place whereBorn) {
        this.whereBorn = whereBorn;
    }

    public String getUntrackedWhereBorn() {
        return untrackedWhereBorn;
    }

    public void setUntrackedWhereBorn(String untrackedWhereBorn) {
        this.untrackedWhereBorn = untrackedWhereBorn;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public String getUntrackedFather() {
        return untrackedFather;
    }

    public void setUntrackedFather(String untrackedFather) {
        this.untrackedFather = untrackedFather;
    }

    public String getFatherRank() {
        return fatherRank;
    }

    public void setFatherRank(String fatherRank) {
        this.fatherRank = fatherRank;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public String getDateAndPlaceOfMarriage() {
        return dateAndPlaceOfMarriage;
    }

    public void setDateAndPlaceOfMarriage(String dateAndPlaceOfMarriage) {
        this.dateAndPlaceOfMarriage = dateAndPlaceOfMarriage;
    }

    public Person getInformant() {
        return informant;
    }

    public void setInformant(Person informant) {
        this.informant = informant;
    }

    public String getUntrackedInformant() {
        return untrackedInformant;
    }

    public void setUntrackedInformant(String untrackedInformant) {
        this.untrackedInformant = untrackedInformant;
    }

    @SuppressWarnings("unused")
    public String getInformantQualification() {
        return informantQualification;
    }

    @SuppressWarnings("unused")
    public void setInformantQualification(String informantQualification) {
        this.informantQualification = informantQualification;
    }

    public String getWhenRegistered() {
        return whenRegistered;
    }

    public void setWhenRegistered(String whenRegistered) {
        this.whenRegistered = whenRegistered;
    }

    public String getWhereRegistered() {
        return whereRegistered;
    }

    public void setWhereRegistered(String whereRegistered) {
        this.whereRegistered = whereRegistered;
    }

    public Place getFatherUsualResidence() {
        return fatherUsualResidence;
    }

    public void setFatherUsualResidence(Place fatherUsualResidence) {
        this.fatherUsualResidence = fatherUsualResidence;
    }

    public String getUntrackedFatherUsualResidence() {
        return untrackedFatherUsualResidence;
    }

    public void setUntrackedFatherUsualResidence(String untrackedFatherUsualResidence) {
        this.untrackedFatherUsualResidence = untrackedFatherUsualResidence;
    }

    public String getInformantResidence() {
        return informantResidence;
    }

    public void setInformantResidence(String informantResidence) {
        this.informantResidence = informantResidence;
    }

    public Place getMotherUsualResidence() {
        return motherUsualResidence;
    }

    public void setMotherUsualResidence(Place motherUsualResidence) {
        this.motherUsualResidence = motherUsualResidence;
    }

    public String getUntrackedMotherUsualResidence() {
        return untrackedMotherUsualResidence;
    }

    public void setUntrackedMotherUsualResidence(String untrackedMotherUsualResidence) {
        this.untrackedMotherUsualResidence = untrackedMotherUsualResidence;
    }

}
