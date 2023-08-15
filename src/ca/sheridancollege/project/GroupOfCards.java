package ca.sheridancollege.project;

import java.util.ArrayList;

public class GroupOfCards {
    private final ArrayList<BlackjackCard> cards;

    public GroupOfCards() {
        this.cards = new ArrayList<>();
    }

    public void addCard(BlackjackCard card) {
        this.cards.add(card);
    }

    public void clear() {
        this.cards.clear();
    }

    public ArrayList<BlackjackCard> getCards() {
        return this.cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BlackjackCard card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}




