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
        // 条件を変更要
        while (dealer.sumPoints() < 17) {
            dealer.addCard(deck.drawCard());
        }
        System.out.println("Dealer's hand: " + dealer);
    }

    private void determineWinner() {
        // 勝敗の判定
    }

    private void placeBet() {
        while (true) {
            // 表示しても内容は分からないかな
            System.out.println("You have " + chipController.getChip() + " chips. How many chips would you like to bet?");
            int chip = scanner.nextInt();
            scanner.nextLine();
            try {
                chipController.bet(chip);
                System.out.println("You have bet " + chip + "Remaining chips: " + chipController.getChip());
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