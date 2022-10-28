package ru.netology;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public ArrayList<Player> findAll() {
        return playerList;
    }

    public Player findByName(String name) {
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new NotRegisteredException("Player with name " + name + "is not registered");
    }

    public int round(String playerName1, String playerName2) {
        int firstPlayerStrength = findByName(playerName1).getStrength();
        int secondPlayerStrength = findByName(playerName2).getStrength();

        if (firstPlayerStrength > secondPlayerStrength) {
            return 1;
        } else if (firstPlayerStrength < secondPlayerStrength) {
            return 2;
        } else {
            return 0;
        }
    }
}