//import java.util.scanner;

public class ERS extends CardGame {

    public int playerOneHandSize = 26;
    public int playerTwoHandSize = 26;

    public ERS() {
        initializeGame();
    }

    @Override
    protected void createDeck() {
        // Create deck (ERS has 52 cards)
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        for (String suit : suits) {
            for (String value : values) {
                deck.add(new Card(value, suit));
            }
        }
    }
    public void playCard(int playerIndex, Card card) {
        // Implement play card logic for ERS
        if (isValidPlay(card)) {
            // Update game state with the played card
            lastPlayedCard = card;
            discardPile.add(card);
        }
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        //computerPlayer = new cards.ERSComputer();
        dealCards(26);
        // Place first card on discard pile
        lastPlayedCard = deck.remove(0);
        discardPile.add(lastPlayedCard);
    }

     @Override
    public void handleCardClick(int mouseX, int mouseY) {
        // Handle card click logic specific to ERS
    }
}
