package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.Card;
import src.main.java.blackjack.CardMark;
import src.main.java.blackjack.CardType;

public class CardTest {
    @Test
    public void isAce() {
        Card card = new Card(CardType.ace, CardMark.diamond);
        Assert.assertTrue(card.isAce());
        Card card2 = new Card(CardType.two, CardMark.heart);
        Assert.assertFalse(card2.isAce());
    }

    @Test
    public void howManyPoint() {
        Card card2 = new Card(CardType.two, CardMark.heart);
        Assert.assertEquals(2, card2.getCardTypePoint());
        Card cardAce = new Card(CardType.ace, CardMark.heart);
        Assert.assertEquals(0, cardAce.getCardTypePoint());
    }
}
