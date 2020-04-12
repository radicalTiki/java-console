package com.audition.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
    * Each player starts the game with 30 Health and 0 Mana slots
    * Each player starts with a deck of 20 Damage cards with the following Mana costs: 0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8
    * From the deck each player receives 3 random cards has his initial hand
*/
public class Player {
    private static final Logger logger = Logger.getLogger(Player.class.getName());

    private static final int HEALTH = 30;
    private static final int TOTAL_MANA = 10;
    private static final Random random = new Random();

    private String name = "";
    private int currentHealth = HEALTH;
    private int currentMana = 0;

    private List<Card> deck = Stream.of(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8)
            .map(Card::new)
            .collect(Collectors.toList());
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        //initialize hand, draw 3 cards
        IntStream.range(0, 3).forEach(e -> drawCard());
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void decreaseHealth(int damage) {
        currentHealth -= damage;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void incrementMana() {
        if (currentMana < TOTAL_MANA)
            currentMana += 1;
    }

    public void descreaseMana(int mana) {
        if (currentMana - mana >= 0) {
            currentMana -= mana;
        }
        else {
            logger.info("could not decrease mana, not enough mana left");
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public void drawCard() {
        if (deck.size() > 0) {
            hand.add(deck.remove(random.nextInt(deck.size())));
        }
        else {
            logger.info("No cards left, taking damage");
            currentHealth -= 1;
        }
    }

    public void printHand() {
        hand.forEach(card -> System.out.print("[Card: " + card.getManaCost() + "] "));
    }
}
