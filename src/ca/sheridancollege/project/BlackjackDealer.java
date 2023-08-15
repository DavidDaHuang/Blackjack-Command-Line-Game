package ca.sheridancollege.project;

public class BlackjackDealer extends BlackjackPlayer {
    

    public BlackjackDealer(String name, ScoreManager scoreManager, CardDrawer cardDrawer, PlayerMoveProvider moveProvider) {
        super(name, scoreManager, cardDrawer, moveProvider);
    }

    @Override
    public void play() {
        while (HandValueCalculator.calculate(this) < 17) {
            addCardToHand(getCardDrawer().drawCard());
        }
    }
}





