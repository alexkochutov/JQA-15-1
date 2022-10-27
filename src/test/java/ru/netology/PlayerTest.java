package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player1 = new Player(1, "player1", 300);

    @Test
    public void shouldGetId() {
        int expected = 1;
        int actual = player1.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetName() {
        String expected = "player1";
        String actual = player1.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStrength() {
        int expected = 300;
        int actual = player1.getStrength();
        assertEquals(expected, actual);
    }
}