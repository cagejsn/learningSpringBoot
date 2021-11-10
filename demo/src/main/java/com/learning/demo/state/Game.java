package com.learning.demo.state;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.demo.model.Bet;
import com.learning.demo.model.Hand;
import com.learning.demo.model.Person;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Game {

    @JsonIgnore
    private Deck deck;

    private BigDecimal dealersMoney;

    private Hand dealerHand;
    private Map<Person, Hand> hands = new HashMap<>();
    private Map<Person, Bet> bets = new HashMap<>();
}
