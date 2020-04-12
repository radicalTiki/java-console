package com.audition.magic;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void playerInitialValueTest() {
        Player player = new Player("test");

        assertEquals("test", player.getName());
        assertEquals(30, player.getCurrentHealth());
        assertEquals(0, player.getCurrentMana());
        assertEquals(3, player.getHand().size());
    }

    @Test
    public void playerManaTest() {
        Player player = new Player("test");

        player.incrementMana();
        assertEquals(1, player.getCurrentMana());

        player.descreaseMana(1);
        assertEquals(0, player.getCurrentMana());

        player.descreaseMana(1);
        assertEquals(0, player.getCurrentMana());

        //check max mana, go 1 over
        IntStream.range(1, 11).forEach(e -> player.incrementMana());
        assertEquals(10, player.getCurrentMana());
    }

    @Test
    public void playerCardTest() {
        Player player = new Player("test");

        //go 1 over our deck size, check damage and card size
        IntStream.range(1, 20).forEach(e -> player.drawCard());
        assertEquals(20, player.getHand().size());
        assertEquals(29, player.getCurrentHealth());
    }
}
