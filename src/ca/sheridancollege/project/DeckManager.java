package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public final class DeckManager {
    private final ArrayList<BlackjackCard> cards;

    public DeckManager() {
        this.cards = new ArrayList<>();
        for (BlackjackCard.Suit suit : BlackjackCard.Suit.values()) {
            for (BlackjackCard.Rank rank : BlackjackCard.Rank.values()) {
                this.cards.add(new BlackjackCard(suit, rank));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public BlackjackCard drawCard() {
        return this.cards.remove(0);
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }
}


