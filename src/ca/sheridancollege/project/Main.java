package ca.sheridancollege.project;

public class Main {
    public static void main(String[] args) {
        ScoreManager scoreManager = new ScoreManager();
        DeckManager deckManager = new DeckManager();
        PlayerMoveProvider moveProvider = new ConsolePlayerMoveProvider();

        BlackjackGame blackjackGame = BlackjackGame.getInstance(scoreManager, deckManager, moveProvider);
        
        blackjackGame.play();
    }
}










