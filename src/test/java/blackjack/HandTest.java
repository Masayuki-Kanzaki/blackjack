package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.*;

public class HandTest {
    @Test
    public void add_Card() {
        Hand hand2 = new Hand();
        hand2.addCard(CardFactory.createCard(CardType.two, CardMark.diamond));
        Assert.assertEquals(2, hand2.showPoints());
        hand2.addCard(CardFactory.createCard(CardType.two, CardMark.heart));
        Assert.assertEquals(4, hand2.showPoints());
    }
}
