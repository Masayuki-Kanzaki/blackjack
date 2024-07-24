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
    public void count_Ace() {
        Hand hand = new Hand();
        hand.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        Assert.assertEquals(1, hand.countAce());
        hand.addCard(CardFactory.createCard(CardType.two, CardMark.diamond));
        Assert.assertEquals(1, hand.countAce());
        hand.addCard(CardFactory.createCard(CardType.ace, CardMark.heart));
        Assert.assertEquals(2, hand.countAce());

        Hand hand2 = new Hand();
        hand2.addCard(CardFactory.createCard(CardType.two, CardMark.diamond));
        Assert.assertEquals(0, hand2.countAce());
    }

    @Test
    public void count_TenCard() {
        Hand hand = new Hand();
        hand.addCard(CardFactory.createCard(CardType.ten, CardMark.diamond));
        Assert.assertEquals(1, hand.countTenCard());
        hand.addCard(CardFactory.createCard(CardType.nine, CardMark.diamond));
        Assert.assertEquals(1, hand.countTenCard());
        hand.addCard(CardFactory.createCard(CardType.jack, CardMark.heart));
        Assert.assertEquals(2, hand.countTenCard());

        Hand hand2 = new Hand();
        hand2.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        Assert.assertEquals(0, hand2.countTenCard());
    }

    @Test
    public void sum_Points_WithoutAce() {
        Hand hand = new Hand();
        hand.addCard(CardFactory.createCard(CardType.ten, CardMark.diamond));
        hand.addCard(CardFactory.createCard(CardType.eight, CardMark.diamond));
        Assert.assertEquals(18, hand.sumPointsWithoutAce());
        hand.addCard(CardFactory.createCard(CardType.two, CardMark.diamond));
        Assert.assertEquals(20, hand.sumPointsWithoutAce());

        Hand hand2 = new Hand();
        hand2.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        Assert.assertEquals(0, hand2.sumPointsWithoutAce());
        hand2.addCard(CardFactory.createCard(CardType.jack, CardMark.diamond));
        Assert.assertEquals(10, hand2.sumPointsWithoutAce());
        hand2.addCard(CardFactory.createCard(CardType.queen, CardMark.diamond));
        Assert.assertEquals(20, hand2.sumPointsWithoutAce());
        hand2.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        Assert.assertEquals(20, hand2.sumPointsWithoutAce());
    }

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
        Assert.assertFalse(hand3.isBlackjack());
    }
    @Test
    public void sum_Points5_for_blackjack() {
        Hand hand5 = new Hand();
        hand5.addCard(CardFactory.createCard(CardType.ace, CardMark.diamond));
        hand5.addCard(CardFactory.createCard(CardType.jack, CardMark.diamond));
        Assert.assertEquals(21, hand5.sumPoints());
        Assert.assertTrue(hand5.isBlackjack());
    }
    @Test
    public void sum_Points6_for_bust() {
        Hand hand6 = new Hand();
        hand6.addCard(CardFactory.createCard(CardType.ten, CardMark.diamond));
        hand6.addCard(CardFactory.createCard(CardType.jack, CardMark.diamond));
        hand6.addCard(CardFactory.createCard(CardType.queen, CardMark.diamond));
        Assert.assertEquals(30, hand6.sumPoints());
        Assert.assertTrue(hand6.isBust());
    }
}
