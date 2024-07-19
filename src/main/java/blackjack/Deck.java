package src.main.java.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }
}
