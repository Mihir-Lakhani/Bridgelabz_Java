/*
10. Write a program to create a deck of cards, initialize the deck, shuffle
the deck, and distribute n cards to x players. Finally, print the cards
the players have.

Hint =>
Create a deck with suits Hearts, Diamonds, Clubs and Spades and ranks
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King and Ace.
Calculate the number of cards:
int numOfCards = suits.length * ranks.length;

Write a method to initialize and return the deck.
Every card should be stored as "rank of suit", such as "2 of Hearts".

Write a method to shuffle the deck.
Loop through the deck and swap every card with a random remaining card:
int randomCardNumber = i + (int)(Math.random() * (n - i));

Write a method to distribute n cards among x players.
Check whether the cards can be distributed equally.
Create a 2D array to store every player and their cards.
Write a method to print all players and their cards.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class DeckOfCards {
    public static String[] makeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8",
                "9", "10", "Jack", "Queen", "King", "Ace"
        };

        int numberOfCards = suits.length * ranks.length;
        String[] deck = new String[numberOfCards];
        int k = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[k] = rank + " of " + suit;
                k++;
            }
        }
        return deck;
    }

    public static String[] shuffle(String[] deck) {
        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber =
                    i + (int) (Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distribute(String[] deck, int cards, int players) {
        if (cards > deck.length || players <= 0 || cards % players != 0) {
            return null;
        }

        int cardsPerPlayer = cards / players;
        String[][] result = new String[players][cardsPerPlayer];
        int k = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                result[i][j] = deck[k];
                k++;
            }
        }
        return result;
    }

    public static void display(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cards to distribute: ");
        int cards = sc.nextInt();

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        String[] deck = makeDeck();
        shuffle(deck);

        String[][] result = distribute(deck, cards, players);

        if (result == null) {
            System.out.println("Cards cannot be distributed equally");
        } else {
            display(result);
        }
        sc.close();
    }
}