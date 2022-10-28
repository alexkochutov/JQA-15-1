package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player player1 = new Player(1, "player1", 600);
    Player player2 = new Player(2, "player2", 450);
    Player player3 = new Player(3, "player3", 500);
    Player player4 = new Player(4, "player4", 500);

    @Test
    public void shouldRegisterPlayer() {
        Game game = new Game();
        game.register(player1);
        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        ArrayList<Player> actual = game.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameInEmptyList() {
        Game game = new Game();
        assertThrows(NotRegisteredException.class, () -> {
            game.findByName("player1");
        });
    }

    @Test
    public void shouldFindByNameInNonEmptyList() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.findByName("player3");
        });
    }

    @Test
    public void shouldFindByName() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Player expected = player2;
        Player actual = game.findByName("player2");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundThrowExceptionFirstIsNotRegistered() {
        Game game = new Game();
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("player1", "player2");
        });
    }

    @Test
    public void shouldRoundThrowExceptionSecondIsNotRegistered() {
        Game game = new Game();
        game.register(player1);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("player1", "player2");
        });
    }

    @Test
    public void shouldRoundFirstWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("player1", "player2");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundSecondWin() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        int expected = 2;
        int actual = game.round("player2", "player3");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWinWin() {
        Game game = new Game();
        game.register(player3);
        game.register(player4);
        int expected = 0;
        int actual = game.round("player3", "player4");
        assertEquals(expected, actual);
    }
}