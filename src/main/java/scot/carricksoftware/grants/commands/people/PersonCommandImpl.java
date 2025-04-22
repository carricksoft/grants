/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 02:05. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.people;

public class PersonCommandImpl implements PersonCommand {

    Long Id;

    String firstName;

    String lastName;

    String recordedYearOfBirth;

    String certifiedYearOfBirth;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getRecordedYearOfBirth() {
        return recordedYearOfBirth;
    }

    @Override
    public void setRecordedYearOfBirth(String recordedYearOfBirth) {
        this.recordedYearOfBirth = recordedYearOfBirth;
    }

    @Override
    public String getCertifiedYearOfBirth() {
        return certifiedYearOfBirth;
    }

    @Override
    public void setCertifiedYearOfBirth(String certifiedYearOfBirth) {
        this.certifiedYearOfBirth = certifiedYearOfBirth;
    }


}
