package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.*;

public class HandTest {
/* 
    @Test
    public void add_Card() {
        Hand hand2 = new Hand();
        hand2.addCard(CardFactory.createCard(CardType.two, CardMark.diamond));
        Assert.assertEquals(2, hand2.showPoints());
        hand2.addCard(CardFactory.createCard(CardType.two, CardMark.heart));
        Assert.assertEquals(4, hand2.showPoints());
    }
*/
@Test
    public void sum_Points() {
        Hand hand3 = new Hand();
        hand3.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        hand3.addCard(CardFactory.createCard(CardType.two, CardMark.heart));
        Assert.assertEquals(13, hand3.sumPoints());
        hand3.addCard(CardFactory.createCard(CardType.eight, CardMark.heart));
        Assert.assertEquals(21, hand3.sumPoints());
    }
    @Test
    public void sum_Points2() {
        Hand hand3 = new Hand();
        hand3.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        hand3.addCard(CardFactory.createCard(CardType.two, CardMark.heart));
        Assert.assertEquals(13, hand3.sumPoints());
        hand3.addCard(CardFactory.createCard(CardType.five, CardMark.heart));
        Assert.assertEquals(18, hand3.sumPoints());
    }
    @Test
    public void sum_Points3() {
        Hand hand3 = new Hand();
        hand3.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        hand3.addCard(CardFactory.createCard(CardType.two, CardMark.heart));
        hand3.addCard(CardFactory.createCard(CardType.five, CardMark.heart));
        Assert.assertEquals(18, hand3.sumPoints());
    }
    @Test
    public void sum_Points4() {
        Hand hand3 = new Hand();
        hand3.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        hand3.addCard(CardFactory.createCard(CardType.two, CardMark.heart));
        hand3.addCard(CardFactory.createCard(CardType.eight, CardMark.heart));
        Assert.assertEquals(21, hand3.sumPoints());
    }
}
