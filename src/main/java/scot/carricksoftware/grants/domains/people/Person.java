/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.people;

import jakarta.persistence.Entity;
import scot.carricksoftware.grants.BaseEntity;

@Entity
public class Person extends BaseEntity {

    String firstName;
    String lastName;
    String recordedYearOfBirth;
    String certifiedYearOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.lastName);
        builder.append(", ");
        builder.append(this.firstName);
        builder.append(", ");
        if (certifiedYearOfBirth != null) {
            builder.append(certifiedYearOfBirth);
            builder.append(" ");
        }  else {
            if (recordedYearOfBirth != null) {
                builder.append("(");
                builder.append(recordedYearOfBirth);
                builder.append(")");
                builder.append(" ");
            }
        }
        builder.append("-");

        return builder.toString();
    }

    public String getRecordedYearOfBirth() {
        return recordedYearOfBirth;
    }

    public void setRecordedYearOfBirth(String recordedYearOfBirth) {
        this.recordedYearOfBirth = recordedYearOfBirth;
    }

    public String getCertifiedYearOfBirth() {
        return certifiedYearOfBirth;
    }

    public void setCertifiedYearOfBirth(String certifiedYearOfBirth) {
        this.certifiedYearOfBirth = certifiedYearOfBirth;
    }
}
