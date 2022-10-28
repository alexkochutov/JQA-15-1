package ru.netology;

import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> playerList = new HashMap<>();

    public void register(Player player) {
        playerList.put(player.getName(), player.getStrength());
    }

    public HashMap<String, Integer> findAll() {
        return playerList;
    }

    public int findByName(String name) {
        if (playerList.containsKey(name)) {
            return playerList.get(name);
        } else {
            throw new NotRegisteredException("Player with name " + name + "is not registered");
        }
    }

    public int round(String playerName1, String playerName2) {
        int firstPlayerStrength = findByName(playerName1);
        int secondPlayerStrength = findByName(playerName2);

        if (firstPlayerStrength > secondPlayerStrength) {
            return 1;
        } else if (firstPlayerStrength < secondPlayerStrength) {
            return 2;
        } else {
            return 0;
        }
    }
}