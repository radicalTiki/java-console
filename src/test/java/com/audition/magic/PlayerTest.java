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
}
