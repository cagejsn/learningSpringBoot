package com.learning.demo.state;

import com.learning.demo.exception.NoMoreCardsException;
import com.learning.demo.model.Card;
import com.learning.demo.model.Rank;
import com.learning.demo.model.Suite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    // draw card
    public Card drawCard() {
        if (cards.size() > 0) {
            return cards.remove(cards.size() - 1);
        } else {
            throw new NoMoreCardsException("no more cards");
        }
    }

    // shuffle
    //TODO

    //init which adds 52 cards to this object
    public Deck() {
        for (Suite suite : Suite.values()) {
            IntStream.range(1, 14).forEach((int rank) -> {
                cards.add(new Card(rank, suite));
            });
        }
    }
}
