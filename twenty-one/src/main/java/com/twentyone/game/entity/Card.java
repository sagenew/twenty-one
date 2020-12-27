package com.twentyone.game.entity;

import com.twentyone.game.entity.enums.Suit;
import com.twentyone.game.entity.enums.Value;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private Value value;
    private Suit suit;

    public Card(Suit suit, Value value) {
        this.value = value;
        this.suit = suit;
    }

    public Value getIntValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        Character value = valuePrintMap.get(this.getIntValue());
        Character suit = suitPrintMap.get(this.getSuit());

        return "[" + value + suit + "]";
    }

    private static final Map<Value,Character> valuePrintMap;
    static {
        valuePrintMap = Map.ofEntries(
                Map.entry(Value.ACE, 'A'),
                Map.entry(Value.TWO, '2'),
                Map.entry(Value.THREE, '3'),
                Map.entry(Value.FOUR, '4'),
                Map.entry(Value.FIVE, '5'),
                Map.entry(Value.SIX, '6'),
                Map.entry(Value.SEVEN, '7'),
                Map.entry(Value.EIGHT, '8'),
                Map.entry(Value.NINE, '9'),
                Map.entry(Value.TEN, 'T'),
                Map.entry(Value.JACK, 'J'),
                Map.entry(Value.QUEEN, 'Q'),
                Map.entry(Value.KING, 'K'));
    }

    private static final Map<Suit,Character> suitPrintMap;
    static {
        suitPrintMap = Map.of(
                Suit.SPADE, '\u2660',
                Suit.HEART, '\u2665',
                Suit.DIAMOND, '\u2666',
                Suit.CLUB, '\u2663');
    }

}
