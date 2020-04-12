package com.audition.magic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void playerInitialValueTest() {
        Player player = new Player("test");
        assertEquals("test", player.getName());
        assertEquals(30, player.getCurrentHealth());
        assertEquals(0, player.getCurrentMana());
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
    }
}
