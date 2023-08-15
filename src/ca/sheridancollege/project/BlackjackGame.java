package ca.sheridancollege.project;


import java.util.ArrayList;

public class BlackjackGame extends Game implements CardDrawer {
    private static BlackjackGame instance;
    private final ScoreManager scoreManager;
    private final DeckManager deckManager;
    private final PlayerManager playerManager;

    public static final String PLAYER_NAME = "Player";
    public static final String DEALER_NAME = "Dealer";

    private BlackjackGame(String name, ScoreManager scoreManager, DeckManager deckManager, PlayerMoveProvider moveProvider) {
        super(name);
        this.scoreManager = scoreManager;
        this.deckManager = deckManager;
        this.playerManager = new PlayerManager();
        this.playerManager.addPlayer(new BlackjackDealer(DEALER_NAME, scoreManager, this, moveProvider));
        this.playerManager.addPlayer(new BlackjackPlayer(PLAYER_NAME, scoreManager, this, moveProvider));
    }

    public static BlackjackGame getInstance(ScoreManager scoreManager, DeckManager deckManager, PlayerMoveProvider moveProvider) {
        if (instance == null) {
            instance = new BlackjackGame("Blackjack", scoreManager, deckManager, moveProvider);
        }
        return instance;
    }

    @Override
    public void play() {
        GameLoopManager gameLoopManager = new GameLoopManager(this, scoreManager);
        gameLoopManager.runGameLoop();
    }

    @Override
    public BlackjackCard drawCard() {
        return deckManager.drawCard();
    }

    public boolean isDeckEmpty() {
        return deckManager.isEmpty();
    }

    @Override
    public void declareWinner() {
        // This method is empty because the logic for declaring a winner has been moved to the GameLoopManager class.
    }

    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> playerList = new ArrayList<>();
        for (BlackjackPlayer blackjackPlayer : playerManager.getPlayers()) {
            playerList.add(blackjackPlayer);
        }
        return playerList;
    }
}








