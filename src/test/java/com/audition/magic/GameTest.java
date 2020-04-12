package com.audition.magic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void testStartRound() {
        Game game = new Game();
        assertEquals(1, game.getRound());
        game.startRound();
        assertEquals(2, game.getRound());
    }

    @Test
    public void testEndGame() {
        Game game = new Game();
        while (game.startRound()) {

        }

        //end of game
        assertTrue(game.getLoser().getCurrentHealth() <= 0);
        assertTrue(game.getWinner().getCurrentHealth() > 0);
    }
}
