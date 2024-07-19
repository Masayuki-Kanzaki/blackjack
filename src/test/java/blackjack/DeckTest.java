package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.*;

public class DeckTest {
    @Test
    public void addCard_and_drawCard() {
        Card card1 = CardFactory.createCard(CardType.ace, CardMark.diamond);
        Card card2 = CardFactory.createCard(CardType.two, CardMark.diamond);

        Deck deck =new Deck();
        deck.addCard(card1);
        deck.addCard(card2);
        Assert.assertEquals(0, deck.drawCard().getCardTypePoint());
        Assert.assertEquals(2, deck.drawCard().getCardTypePoint());
//      Assert.assertEquals(2, deck.drawCard().getCardTypePoint());
    }

    @Test
    public void shuffle() {
        Card card1 = CardFactory.createCard(CardType.ace, CardMark.diamond);
        Card card2 = CardFactory.createCard(CardType.two, CardMark.diamond);

        Deck deck =new Deck();
        deck.addCard(card1);
        deck.addCard(card2);
        deck.shuffle();
        Assert.assertEquals(0, deck.drawCard().getCardTypePoint() % 2);
    }

}
