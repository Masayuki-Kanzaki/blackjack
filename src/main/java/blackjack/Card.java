package src.main.java.blackjack;

public class Card {
    CardType type;
    CardMark mark;

    public Card(CardType type, CardMark mark) {
        this.type = type;
        this.mark = mark;
    }
    public boolean isAce() {
        return type.equals(CardType.ace);
    }
}
