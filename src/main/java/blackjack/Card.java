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

    public boolean isTenCard() {
        if (type.getPoint() == 10) {
            return true;
        }
        return false;
    }

    public int getCardTypePoint() {
        return type.getPoint();
    }

    public CardType getCardType() {
        return type;
    }

    public CardMark getCardMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Card: " + type + " of " + mark;
    }
}
