package com.audition.magic;

/**
 * Preparation
 * Each player starts the game with 30 Health and 0 Mana slots
 * Each player starts with a deck of 20 Damage cards with the following Mana costs: 0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8
 * From the deck each player receives 3 random cards has his initial hand
 * Gameplay
 * The active player receives 1 Mana slot up to a maximum of 10 total slots
 * The active player’s empty Mana slots are refilled
 * The active player draws a random card from his deck
 * The active player can play as many cards as he can afford. Any played card empties Mana slots and deals immediate damage to the opponent player equal to its Mana cost.
 * If the opponent player’s Health drops to or below zero the active player wins the game
 * If the active player can’t (by either having no cards left in his hand or lacking sufficient Mana to pay for any hand card) or simply doesn’t want to play another card, the opponent player becomes active
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Trading Card Game - Magic!");
    }
}
