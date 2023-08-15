package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class GameLoopManager {
    private static final int INITIAL_CARDS_COUNT = 2;
    private final BlackjackGame game;
    private final ScoreManager scoreManager;

    public GameLoopManager(BlackjackGame game, ScoreManager scoreManager) {
        this.game = game;
        this.scoreManager = scoreManager;
    }

    public void runGameLoop() {
        List<Player> playersList = game.getPlayers();
        List<BlackjackPlayer> players = new ArrayList<>();
        for (Player p : playersList) {
            if (p instanceof BlackjackPlayer) {
                players.add((BlackjackPlayer) p);
            }
        }

        while (true) {
            dealInitialCards(players);
            System.out.println("Dealer's face-up card: " + players.get(0).getHand().getCards().get(0));

            for (BlackjackPlayer player : players) {
                if (player.getCardDrawer() != null) {
                    player.play();
                }
            }

            declareWinner(players);
            clearHands(players);

            if (isGameOver() || scoreManager.isGameOver()) {
                break;
            }
        }
    }

    private void dealInitialCards(List<BlackjackPlayer> players) {
        for (BlackjackPlayer player : players) {
            dealCards(INITIAL_CARDS_COUNT, player);
            if (!player.getName().equals(BlackjackGame.DEALER_NAME)) {
                System.out.println(player.getName() + "'s initial cards: " + player.getHand().getCards());
            }
        }
    }
    

    private void dealCards(int numberOfCards, BlackjackPlayer player) {
        for (int i = 0; i < numberOfCards; i++) {
            player.addCardToHand(game.drawCard());
        }
    }

    private void clearHands(List<BlackjackPlayer> players) {
        for (BlackjackPlayer player : players) {
            player.clearHand();
        }
    }

    private boolean isGameOver() {
        return game.isDeckEmpty();
    }


    private void declareWinner(List<BlackjackPlayer> players) {
        BlackjackPlayer player = players.get(1);
        BlackjackPlayer dealer = players.get(0);
        int playerValue = HandValueCalculator.calculate(player);
        int dealerValue = HandValueCalculator.calculate(dealer);

        if (isBlackjack(player) && !isBlackjack(dealer)) {
            System.out.println("Player has Blackjack! Player wins!");
            scoreManager.addScore(BlackjackGame.PLAYER_NAME, playerValue);
        } else if (!isBlackjack(player) && isBlackjack(dealer)) {
            System.out.println("Dealer has Blackjack! Dealer wins!");
            scoreManager.addScore(BlackjackGame.DEALER_NAME, dealerValue);
        } else if (playerValue > 21) {
            System.out.println("Player busts. Dealer wins!");
            scoreManager.addScore(BlackjackGame.DEALER_NAME, dealerValue);
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts. Player wins!");
            scoreManager.addScore(BlackjackGame.PLAYER_NAME, playerValue);
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
            scoreManager.addScore(BlackjackGame.PLAYER_NAME, playerValue);
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins!");
            scoreManager.addScore(BlackjackGame.DEALER_NAME, dealerValue);
        } else {
            System.out.println("It's a draw!");
        }

        System.out.println("Score: " + scoreManager.getScore(BlackjackGame.PLAYER_NAME) + " : " + scoreManager.getScore(BlackjackGame.DEALER_NAME));

        if (scoreManager.isGameOver()) {
            System.out.println(scoreManager.getWinner() + " wins the game!");
        }
    }

    private boolean isBlackjack(BlackjackPlayer player) {
        if (player.getHand().getCards().size() == 2) {
            BlackjackCard card1 = player.getHand().getCards().get(0);
            BlackjackCard card2 = player.getHand().getCards().get(1);
            return (card1.getRank() == BlackjackCard.Rank.ACE && card2.getRank().getValue() == 10) ||
                    (card2.getRank() == BlackjackCard.Rank.ACE && card1.getRank().getValue() == 10);
        }
        return false;
    }
}

