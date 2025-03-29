package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullNameShouldReturnConcatenatedName() {
        Person person = new Person("Zakaria", "bougadi", 25);
        assertEquals("Zakaria bougadi", person.getFullName());
    }

    @Test
    void isAdultShouldReturnFalseIfAgeIsLessThan18() {
        Person teen = new Person("djeloul", "bari", 17);
        assertFalse(teen.isAdult());
    }

    @Test
    void isAdultShouldReturnTrueIfAgeIs18() {
        Person justAdult = new Person("hadji", "issam", 18);
        assertTrue(justAdult.isAdult());
    }

    @Test
    void isAdultShouldReturnTrueIfAgeIsGreaterThan18() {
        Person adult = new Person("zwatin", "hmida", 30);
        assertTrue(adult.isAdult());
    }
}
