package ca.sheridancollege.project;

public class BlackjackPlayer extends Player {
    private final CardDrawer cardDrawer;
    private final PlayerMoveProvider moveProvider;
    private final GroupOfCards hand;

    public BlackjackPlayer(String name, ScoreManager scoreManager, CardDrawer cardDrawer, PlayerMoveProvider moveProvider) {
        super(name);
        this.cardDrawer = cardDrawer;
        this.moveProvider = moveProvider;
        this.hand = new GroupOfCards();
    }

    public void addCardToHand(BlackjackCard card) {
        this.hand.addCard(card);
    }

    public void clearHand() {
        this.hand.clear();
    }

    public GroupOfCards getHand() {
        return this.hand;
    }

    @Override
public void play() {
    while (true) {
        PlayerMove move = moveProvider.getMove();
        switch (move) {
            case HIT:
                addCardToHand(cardDrawer.drawCard());
                System.out.println("Current hand: \n" + getHand());
                if (HandValueCalculator.calculate(this) > 21) {
                    System.out.println("Bust! You've exceeded 21.");
                    return;
                }
                break;
            case STAND:
                return;
        }
    }
}


    public CardDrawer getCardDrawer() {
        return cardDrawer;
    }
}


















