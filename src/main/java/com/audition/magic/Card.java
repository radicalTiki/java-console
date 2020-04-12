package com.audition.magic;

public class Card implements Comparable<Card> {
    private int manaCost;

    Card(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getManaCost() {
        return manaCost;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.manaCost, o.getManaCost());
    }
}
