package src.main.java.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    static final int MAX = 21;

    boolean blackjack = false;
    boolean bust = false;

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
//        points += card.getCardTypePoint();
    }
/* 
    public void showCards() {
        for (int i = 0; i < cards.size(); i++) {
            //
        }
    }
*/
    public int showPoints() {
        return sumPoints();
    }

    public int sumPoints() {
        int points = 0;
        int countAce = 0;
        int countTenCard = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            points += card.getCardTypePoint();
            if (card.isAce()) {
                countAce += 1;
            }
            if (card.isTenCard()) {
                countTenCard += 1;
            }
        }

        for (int i = 0; i < countAce; i++) {
            if (points >= MAX) {
                points += 1;
                bust = true;
                continue;
            } else if ((points % 21 <= 20) && (points % 21 >= 11)) {
                points += 1;
            } else if ((points % 21 == 10) && (countTenCard == 1)){
                points += 11;
                blackjack = true;
            } else {
                // もう少しケース分岐の検討要
                points += 11;
            }
        }

        if (points > MAX) {
            bust = true;
        }
    
        return points;
    }

    public boolean isBust() {
        return bust;
    }

}