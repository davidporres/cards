import java.util.Collections;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ERS extends CardGame implements KeyListener {

    private static final int CARDS_PER_PLAYER = 26;

    // stack positions
    private static final int p1x = 80;
    private static final int p1y = 600;
    private static final int p2x = 80;
    private static final int p2y = 80;

    private static final int cardW = 80;
    private static final int cardH = 120;

    // tiny offsets so the stack has thickness
    private static final int stackXOffset = 0;
    private static final int stackYOffset = 2;

    public ERS() {
        // cardgame constructor already initializes and deals
    }

    @Override
    protected void createDeck() {
        deck.clear();
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        for (String suit : suits) {
            for (String value : values) {
                deck.add(new ERSCard(value, suit));
            }
        }
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        // no rules yet: no starting discard pile card
        discardPile.clear();
        lastPlayedCard = null;
    }

    @Override
    protected void dealCards(int ignored) {
        Collections.shuffle(deck);

        // reset hands (just in case)
        playerOneHand = new Hand();
        playerTwoHand = new Hand();

        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            Card c1 = deck.remove(0);
            c1.setTurned(true); // ERS stacks are face-down
            playerOneHand.addCard(c1);

            Card c2 = deck.remove(0);
            c2.setTurned(true);
            playerTwoHand.addCard(c2);
        }

        // stack the cards nicely
        stackHand(playerOneHand, p1x, p1y);
        stackHand(playerTwoHand, p2x, p2y);
    }

    private void stackHand(Hand hand, int x, int y) {
        for (int i = 0; i < hand.getSize(); i++) {
            Card c = hand.getCard(i);
            c.setPosition(
                x + i * stackXOffset,
                y + i * stackYOffset,
                cardW,
                cardH
            );
        }
    }

   // @Override
    public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    switch (keyCode) {
        case KeyEvent.p:
            // Handle p key -- p1 play card
            break;
        case KeyEvent.q:
            // Handle q key -- p2 play card
            break;
        case KeyEvent.a:
            // Handle the a key -- p1 slap
            break;
        case KeyEvent.l:
            // Handle the 'l' key -- p2 slap
            break;
        
    }
}
}