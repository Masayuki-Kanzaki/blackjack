package src.main.java.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int points = 0;

    public Hand () {
        this.cards = new ArrayList<>();
    }
/* 
    public Hand (List<Card> card) {
        this.cards = card;
        this.points = 2;
    }
*/
/* 
    public Hand add(Card card) {
        List<Card> result = new ArrayList<>(cards);
        result.add(card);
        return new Hand(result);
    }
*/
    public void addCard(Card card) {
        cards.add(card);
        points += card.getCardTypePoint();
    }
/* 
    public void showCards() {
        for (int i = 0; i < cards.size(); i++) {
            //
        }
    }
*/
    public int showPoints() {
        return points;
    }
}