/*
 * Copyright (c)  11 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants.commands.people;

import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class PersonCommand {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 40, message = "First name must be between 3 and 40 characters.")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 40, message = "Last name must be between 3 and 40 characters.")
    private String lastName;

    public PersonCommand() {
        // required by JPA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
