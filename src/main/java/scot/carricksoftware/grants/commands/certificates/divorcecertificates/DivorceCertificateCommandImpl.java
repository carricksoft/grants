/*
 * Copyright (c) Andrew Grant of Carrick Software 26/03/2025, 23:53. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates.divorcecertificates;

import scot.carricksoftware.grants.domains.people.Person;

public class DivorceCertificateCommandImpl implements DivorceCertificateCommand {

    Long Id;

    private Person firstParty;

    private Person secondParty;

    private String registeredDate;

    private String firstPartyDate;

    private String secondPartyDate;


    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    @Override
    public Person getFirstParty() {
        return firstParty;
    }

    @Override
    public void setFirstParty(Person firstParty) {
        this.firstParty = firstParty;
    }

    @Override
    public Person getSecondParty() {
        return secondParty;
    }

    @Override
    public void setSecondParty(Person secondParty) {
        this.secondParty = secondParty;
    }

    @Override
    public String getRegisteredDate() {
        return registeredDate;
    }

    @Override
    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String getFirstPartyDate() {
        return firstPartyDate;
    }

    @Override
    public void setFirstPartyDate(String firstPartyDate) {
        this.firstPartyDate = firstPartyDate;
    }

    @Override
    public String getSecondPartyDate() {
        return secondPartyDate;
    }

    @Override
    public void setSecondPartyDate(String secondPartyDate) {
        this.secondPartyDate = secondPartyDate;
    }
}
