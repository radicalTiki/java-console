package com.audition.magic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testStartRound() {
        Game game = new Game();
        game.startRound();

        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        game.startRound();
    }
}
