package ca.sheridancollege.project;

import java.util.ArrayList;

public class PlayerManager {
    private final ArrayList<BlackjackPlayer> players;

    public PlayerManager() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(BlackjackPlayer player) {
        this.players.add(player);
    }

    public ArrayList<BlackjackPlayer> getPlayers() {
        return this.players;
    }
}

