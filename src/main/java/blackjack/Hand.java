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
    public Hand add(Card card) {
        List<Card> result = new ArrayList<>(cards);
        result.add(card);
        return new Hand(result);
    }
*/
    public void addCard(Card card) {
        cards.add(card);
    }
 
    public void showCards() {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.println(card);
        }
    }

    public int showPoints() {
        return sumPoints();
    }

    public int countAce() {
        int countAce = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.isAce()) {
                countAce += 1;
            }
        }
        return countAce;
    }

    public int countTenCard() {
        int countTenCard = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.isTenCard()) {
                countTenCard += 1;
            }
        }
        return countTenCard;
    }

    public int sumPointsWithoutAce() {
        int points = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            points += card.getCardRankPoint();
        }
        return points;
    }
/* 
    public boolean isAboveTwentyOne() {
        return bust;
    }
*/
    public int sumPoints() {
        int points = sumPointsWithoutAce();
        for (int i = 0; i < countAce(); i++) {
            if ((points % 21 <= 20) && (points % 21 >= 11)) {
                points += 1;
            } else if ((points % 21 == 10) && (countTenCard() == 1)){
                points += 11;
                blackjack = true;
            } else {
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

    public boolean isBlackjack() {
        return blackjack;
    }

    public boolean isAceForEleven() {
        if (isBust()) {return false;}
        if (countAce() == 0) {return false;}
        int pointsTotal = sumPoints();
        int points = sumPointsWithoutAce();
        int remaining = pointsTotal - points;
        if (remaining / 11 > 0) {return true;}
        return false;
    }

    public boolean isDealerHandSeventeenOrMore() {
        int points = sumPoints();
        if (points > 17) {return true;}
        if (points == 17 && !isAceForEleven()) {return true;}
        return false;
    }
}