/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grants.capitalisation.images.personimages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.capitalisation.CapitaliseString;
import scot.carricksoftware.grants.commands.images.PersonImageCommand;
import scot.carricksoftware.grants.commands.images.PersonImageCommandImpl;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CapitalisePersonImageTest {

    private CapitalisePersonImage capitalisePersonImage;

    @Mock
    CapitaliseString capitaliseStringMock;

    @BeforeEach
    void setUp() {
        capitalisePersonImage = new CapitalisePersonImageImpl(capitaliseStringMock);
    }

    @Test
    void capitaliseCaptionTest() {
        String lower = "lower";
        PersonImageCommand personImageCommand = new PersonImageCommandImpl();
        personImageCommand.setCaption(lower);

        capitalisePersonImage.capitalise(personImageCommand);
        verify(capitaliseStringMock).capitalise("lower");
    }
}