package src.main.java.blackjack;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() {
        deck = new LinkedList<>();
        CardType[] cardTypes = CardType.values();
        CardMark[] cardMarks = CardMark.values();
        
        for (CardType type : cardTypes) {
            for (CardMark mark : cardMarks) {
                deck.add(new Card(type, mark));
            }
        }
        shuffle();
    }

    public void addCard(Card card) {
        // unit test用
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