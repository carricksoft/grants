/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:52. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.marriagecertificates;

import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.places.Place;

public class MarriageCertificateCommandImpl implements MarriageCertificateCommand {

    private Long Id;
    private Person bride;
    private Person groom;
    private String whenMarried;
    private Place whereMarried;
    private String untrackedWhereMarried;
    private String groomAge;
    private String brideAge;
    private String groomCondition;
    private String brideCondition;
    private String groomRank;
    private String brideRank;
    private Place groomUsualResidence;
    private Place brideUsualResidence;
    private String groomUntrackedResidence;
    private String brideUntrackedResidence;
    private Person groomFather;
    private Person brideFather;
    private String groomUntrackedFather;
    private String brideUntrackedFather;
    private String brideFatherRank;
    private Person firstWitness;
    private Person secondWitness;
    private String untrackedFirstWitness;
    private String untrackedSecondWitness;


    @Override
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getBride() {
        return bride;
    }

    @Override
    public void setBride(Person bride) {
        this.bride = bride;
    }

    @Override
    public Person getGroom() {
        return groom;
    }

    @Override
    public void setGroom(Person groom) {
        this.groom = groom;
    }

    @Override
    public String getWhenMarried() {
        return whenMarried;
    }

    @Override
    public void setWhenMarried(String whenMarried) {
        this.whenMarried = whenMarried;
    }

    @Override
    public Place getWhereMarried() {
        return whereMarried;
    }

    @Override
    public void setWhereMarried(Place whereMarried) {
        this.whereMarried = whereMarried;
    }

    @Override
    public String getUntrackedWhereMarried() {
        return untrackedWhereMarried;
    }

    @Override
    public void setUntrackedWhereMarried(String untrackedWhereMarried) {
        this.untrackedWhereMarried = untrackedWhereMarried;
    }

    @Override
    public String getGroomAge() {
        return groomAge;
    }

    @Override
    public void setGroomAge(String groomAge) {
        this.groomAge = groomAge;
    }

    @Override
    public String getBrideAge() {
        return brideAge;
    }

    @Override
    public void setBrideAge(String brideAge) {
        this.brideAge = brideAge;
    }

    @Override
    public String getGroomCondition() {
        return groomCondition;
    }

    @Override
    public void setGroomCondition(String groomCondition) {
        this.groomCondition = groomCondition;
    }

    @Override
    public String getBrideCondition() {
        return brideCondition;
    }

    @Override
    public void setBrideCondition(String brideCondition) {
        this.brideCondition = brideCondition;
    }

    @Override
    public String getGroomRank() {
        return groomRank;
    }

    @Override
    public void setGroomRank(String groomRank) {
        this.groomRank = groomRank;
    }

    @Override
    public String getBrideRank() {
        return brideRank;
    }

    @Override
    public void setBrideRank(String brideRank) {
        this.brideRank = brideRank;
    }

    @Override
    public Place getGroomUsualResidence() {
        return groomUsualResidence;
    }

    @Override
    public void setGroomUsualResidence(Place groomUsualResidence) {
        this.groomUsualResidence = groomUsualResidence;
    }

    @Override
    public Place getBrideUsualResidence() {
        return brideUsualResidence;
    }

    @Override
    public void setBrideUsualResidence(Place brideUsualResidence) {
        this.brideUsualResidence = brideUsualResidence;
    }

    @Override
    public String getGroomUntrackedResidence() {
        return groomUntrackedResidence;
    }

    @Override
    public void setGroomUntrackedResidence(String groomUntrackedResidence) {
        this.groomUntrackedResidence = groomUntrackedResidence;
    }

    @Override
    public String getBrideUntrackedResidence() {
        return brideUntrackedResidence;
    }

    @Override
    public void setBrideUntrackedResidence(String brideUntrackedResidence) {
        this.brideUntrackedResidence = brideUntrackedResidence;
    }

    @Override
    public Person getGroomFather() {
        return groomFather;
    }

    @Override
    public void setGroomFather(Person groomFather) {
        this.groomFather = groomFather;
    }

    @Override
    public Person getBrideFather() {
        return brideFather;
    }

    @Override
    public void setBrideFather(Person brideFather) {
        this.brideFather = brideFather;
    }

    @Override
    public String getGroomUntrackedFather() {
        return groomUntrackedFather;
    }

    @Override
    public void setGroomUntrackedFather(String groomUntrackedFather) {
        this.groomUntrackedFather = groomUntrackedFather;
    }

    @Override
    public String getBrideUntrackedFather() {
        return brideUntrackedFather;
    }

    @Override
    public void setBrideUntrackedFather(String brideUntrackedFather) {
        this.brideUntrackedFather = brideUntrackedFather;
    }

    @Override
    public String getBrideFatherRank() {
        return brideFatherRank;
    }

    @Override
    public void setBrideFatherRank(String brideFatherRank) {
        this.brideFatherRank = brideFatherRank;
    }

    @Override
    public Person getFirstWitness() {
        return firstWitness;
    }

    @Override
    public void setFirstWitness(Person firstWitness) {
        this.firstWitness = firstWitness;
    }

    @Override
    public Person getSecondWitness() {
        return secondWitness;
    }

    @Override
    public void setSecondWitness(Person secondWitness) {
        this.secondWitness = secondWitness;
    }

    @Override
    public String getUntrackedFirstWitness() {
        return untrackedFirstWitness;
    }

    @Override
    public void setUntrackedFirstWitness(String untrackedFirstWitness) {
        this.untrackedFirstWitness = untrackedFirstWitness;
    }

    @Override
    public String getUntrackedSecondWitness() {
        return untrackedSecondWitness;
    }

    @Override
    public void setUntrackedSecondWitness(String untrackedSecondWitness) {
        this.untrackedSecondWitness = untrackedSecondWitness;
    }
}
