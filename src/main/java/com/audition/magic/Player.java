package com.audition.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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

    private String name = "";
    private int currentHealth = 30;
    private int currentMana = 0;

    private List<Card> deck = Stream.of(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8)
            .map(Card::new)
            .collect(Collectors.toList());
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
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
        currentMana += 1;
    }

    public void descreaseMana(int mana) {
        if (currentMana - mana >= 0) {
            currentMana -= mana;
        }
        else {
            logger.info("not enough mana");
        }
    }

    public void printHand() {
        hand.forEach(card -> System.out.print("[Card: " + card.getManaCost() + "] "));
    }
}
