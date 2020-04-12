package com.audition.magic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
    * Each player starts the game with 30 Health and 0 Mana slots
    * Each player starts with a deck of 20 Damage cards with the following Mana costs: 0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8
    * From the deck each player receives 3 random cards has his initial hand
*/
public class Player {
    private String name = "";
    private int health = 30;
    private int currentMana = 0;
    private int totalMana = 0;

    private List<Card> deck = Stream.of(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8)
            .map(Card::new)
            .collect(Collectors.toList());
    private List<Card> hand = new ArrayList<>();

    public void Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printHand() {
        hand.forEach(card -> System.out.print("[Card: " + card.getManaCost() + "] "));
    }

}
