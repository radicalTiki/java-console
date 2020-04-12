package com.audition.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Player {
    private static final Logger logger = Logger.getLogger(Player.class.getName());

    private static final int MAX_HEALTH = 30;
    private static final int MAX_MANA = 10;
    private static final Random random = new Random();

    private String name = "";
    private int currentHealth = MAX_HEALTH;
    private int totalMana = 0;
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
        if (totalMana < MAX_MANA)
            totalMana += 1;
    }

    public void resetMana() {
        currentMana = totalMana;
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

    public int playCard(Card card) {
        hand.remove(card);
        currentMana -= card.getManaCost();
        return card.getManaCost();
    }

    public List<Card> getPlayableCards() {
        return hand.stream()
                .filter(e -> e.getManaCost() <= currentMana)
                .collect(Collectors.toList());
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
        System.out.print("Current Hand: ");
        hand.forEach(card -> System.out.print("[Card: " + card.getManaCost() + "] "));
        System.out.println(" ");
        System.out.println(" ");
    }
}
