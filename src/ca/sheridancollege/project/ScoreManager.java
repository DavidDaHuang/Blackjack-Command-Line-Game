package ca.sheridancollege.project;

import java.util.HashMap;

public class ScoreManager {

    private static final int WINNING_SCORE = 50;
    private final HashMap<String, Integer> score;

    public ScoreManager() {
        score = new HashMap<>();
        score.put(BlackjackGame.PLAYER_NAME, 0);
        score.put(BlackjackGame.DEALER_NAME, 0);
    }

    public void addScore(String player, int value) {
        score.put(player, score.get(player) + value);
    }

    public int getScore(String player) {
        return score.get(player);
    }

    public boolean isGameOver() {
        return score.get(BlackjackGame.PLAYER_NAME) >= WINNING_SCORE || score.get(BlackjackGame.DEALER_NAME) >= WINNING_SCORE;
    }

    public String getWinner() {
        if (isGameOver()) {
            return score.get(BlackjackGame.PLAYER_NAME) >= WINNING_SCORE ? BlackjackGame.PLAYER_NAME : BlackjackGame.DEALER_NAME;
        }
        return null;
    }
}



