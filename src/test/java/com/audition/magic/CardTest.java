package com.audition.magic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    public void CardManaTest() {
        Card card = new Card(0);
        assertEquals(0, card.getManaCost());
    }
}
