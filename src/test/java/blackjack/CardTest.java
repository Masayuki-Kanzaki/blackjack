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
    }
}
