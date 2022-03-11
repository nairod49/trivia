package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Settings {

    ArrayList<Player> players;
    int goldWin;
    boolean rock;

    public Settings() {
    }

    public Settings(ArrayList<Player> players, int goldWin, boolean rock) {
        this.players = players;
        this.goldWin = goldWin;
        this.rock = rock;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getGoldWin() {
        return goldWin;
    }

    public void setGoldWin(int goldWin) {
        this.goldWin = goldWin;
    }

    public boolean isRock() {
        return rock;
    }

    public void setRock(boolean rock) {
        this.rock = rock;
    }
}
