package ca.sheridancollege.project;

public class HandValueCalculator {
    public static int calculate(BlackjackPlayer player) {
        int value = 0;
        int aceCount = 0;

        for (Card c : player.getHand().getCards()) {
            BlackjackCard card = (BlackjackCard) c;
            switch (card.getRank()) {
                case ACE:
                    aceCount++;
                    value += 11;
                    break;
                case TWO: value += 2; break;
                case THREE: value += 3; break;
                case FOUR: value += 4; break;
                case FIVE: value += 5; break;
                case SIX: value += 6; break;
                case SEVEN: value += 7; break;
                case EIGHT: value += 8; break;
                case NINE: value += 9; break;
                default: value += 10; break;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }
}

