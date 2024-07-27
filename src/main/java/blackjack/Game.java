package src.main.java.blackjack;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private Hand player;
    private Hand dealer;
    private ChipController chipController;
    private Scanner scanner;

    public Game(Deck deck, Hand player, Hand dealer, ChipController chipController, Scanner scanner) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
        this.chipController = chipController;
        this.scanner = scanner;
        dealInitialCards();
    }

    private void dealInitialCards() {
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
    }

    private void dealerTurn() {
        while (!dealer.isDealerHandSeventeenOrMore()) {
            dealer.addCard(deck.drawCard());
        }
        System.out.println("Dealer's hand: " + dealer);
    }

    private void determineWinner() {
        if (player.sumPoints() > dealer.sumPoints()) {
            System.out.println("Player wins.");
        } else if (player.sumPoints() < dealer.sumPoints()) {
            System.out.println("Dealer wins. Player loses.");
        } else {
            System.out.println("Player draws.");
        } 
    }

    private void placeBet() {
        while (true) {
            // 表示しても内容は分からないかな
            System.out.println("You have " + chipController.getCredit() + " credit. How many chips would you like to bet?");
            int chip = scanner.nextInt();
            scanner.nextLine();
            try {
                chipController.bet(chip);
                System.out.println("You have bet " + chip + ". Remaining credit: " + chipController.getCredit());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid bet. Not enough chips.");
            }
        }
    }

    public void play() {
        System.out.println("Player's " + player);
        System.out.println("Dealer's " + dealer);

        placeBet();

        while (true) {
            System.out.println("Do you want to 'hit' or 'stand'?");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("hit")) {
                player.addCard(deck.drawCard());
                // 表示しても内容は分からないかな
                System.out.println("Player's " + player);
                if (player.isBust()) {
                    System.out.println("Player busts! Dealer wins");
                    break;
                }
            } else if (action.equalsIgnoreCase("stand")) {
                System.out.println("Player stands! Dealer's turn.");
                dealerTurn();
                determineWinner();
                break;
            } else {
                System.out.println("Invalid action. Please type 'hit' or 'stand'.");
            }
        }
    }
}