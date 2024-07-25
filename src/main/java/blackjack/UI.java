package src.main.java.blackjack;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();
        ChipController chipController = new ChipController();
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(deck, player, dealer, chipController, scanner);
        game.play();
    }
}