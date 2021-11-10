package com.learning.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Hand {
    private List<Card> cards;

    public Hand(List<Card> initialCards) {
        this.cards = initialCards;
    }

    public List<Card> hitPlayerHand(Card card){
        this.cards.add(card);
        return cards;
    }



    public int getHandValue(){
        return 20;
    }
    public boolean is21(){
        return false;
    }


}
