package com.audition.magic;

import java.util.List;
import java.util.Optional;

/**
 * The active player receives 1 Mana slot up to a maximum of 10 total slots
 * The active player’s empty Mana slots are refilled
 * The active player draws a random card from his deck
 * The active player can play as many cards as he can afford. Any played card empties Mana slots and deals immediate damage to the opponent player equal to its Mana cost.
 * If the opponent player’s Health drops to or below zero the active player wins the game
 * If the active player can’t (by either having no cards left in his hand or lacking sufficient Mana to pay for any hand card) or simply doesn’t want to play another card, the opponent player becomes active
 */
public class Game {
    Player player1;
    Player player2;

    Player winner;
    Player loser;

    int round = 1;

    public Game() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    /**
     * Run the round, and determine if there is a winner of the game.
     *
     * @return true if we can continue, false if someone has died
     */
    public boolean startRound() {

        System.out.println("Starting round: " + round);
        System.out.println(" ");

        System.out.println("Player : " + player1.getName() + " starting --");
        player1.drawCard();
        player1.incrementMana();
        player1.resetMana();
        System.out.println("Health " + player1.getCurrentHealth() + " | Mana " + player1.getCurrentMana());
        player1.printHand();

        List<Card> playableCards = player1.getPlayableCards();
        while(playableCards.size() > 0) {
            Optional<Card> cardOpt = playableCards.stream()
                    .max(Card::compareTo);
            Card card = cardOpt.get();

            System.out.println("Playing card: " + card.getManaCost());

            if (!player2.decreaseHealth(player1.playCard(card))) {
                winner = player1;
                loser = player2;
                return false;
            }

            playableCards = player1.getPlayableCards();
        }

        System.out.println("Player : " + player2.getName() + " starting --");
        player2.drawCard();
        player2.incrementMana();
        player2.resetMana();
        System.out.println("Health " + player2.getCurrentHealth() + " | Mana " + player2.getCurrentMana());
        player2.printHand();

        playableCards = player2.getPlayableCards();
        while(playableCards.size() > 0) {
            Optional<Card> cardOpt = playableCards.stream()
                    .max(Card::compareTo);
            Card card = cardOpt.get();

            System.out.println("Playing card: " + card.getManaCost());

            if (!player1.decreaseHealth(player2.playCard(card))) {
                winner = player2;
                loser = player1;
                return false;
            }

            playableCards = player2.getPlayableCards();
        }

        round +=1;

        return true;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }
}
