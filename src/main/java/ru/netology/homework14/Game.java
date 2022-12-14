package ru.netology.homework14;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player" + playerName1 + "is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player" + playerName2 + "is not registered");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;

        } else {
            return 2;
        }
    }
}
