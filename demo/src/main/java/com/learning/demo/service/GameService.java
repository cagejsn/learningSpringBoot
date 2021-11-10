package com.learning.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.demo.exception.BustException;
import com.learning.demo.exception.UnableToPlaceBetException;
import com.learning.demo.model.Bet;
import com.learning.demo.model.Card;
import com.learning.demo.model.Hand;
import com.learning.demo.model.Person;
import com.learning.demo.state.Deck;
import com.learning.demo.state.Game;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private Game game;

    ObjectMapper objectMapper = new ObjectMapper();

    public String getGameResults() throws JsonProcessingException {

        // check the game state,
        // if it is ready, then do logic for allocating Bets to different people


        // can return gameInProgress
        return objectMapper.writeValueAsString(game);
    }

    public Hand deal(Person person) throws BustException{

        if (game.getHands().containsKey(person)) {
            // person already has some cards
            Card card = game.getDeck().drawCard();
            Hand existingHandForPerson = game.getHands().get(person);
            existingHandForPerson.hitPlayerHand(card);

            //bust
            if(existingHandForPerson.getHandValue() > 21) {
                throw new BustException("busted");
            }

            return existingHandForPerson;

        } else {
            List cardList = new ArrayList(List.of(game.getDeck().drawCard(), game.getDeck().drawCard()));
            Hand newHand = new Hand(cardList);
            game.getHands().put(person, newHand);
            return newHand;
        }

    }

    private void applyBet(Bet bet) {

        bet.getPerson().setMoney(bet.getPerson().getMoney().add(bet.getAmount()));

    }

    public void placeBet(Bet bet) throws UnableToPlaceBetException {
        if(bet.getPerson().getMoney().subtract(bet.getAmount()).compareTo(BigDecimal.ZERO) > 0){
            throw new UnableToPlaceBetException("not enough money");
        }

        game.setDealersMoney(game.getDealersMoney().add(bet.getAmount()));
        bet.getPerson().setMoney(bet.getPerson().getMoney().subtract(bet.getAmount()));
        game.getBets().put(bet.getPerson(), bet);

    }

    public void newGame() {
        game = new Game();
        game.setDeck(new Deck());
        game.setDealerHand(new Hand(List.of(game.getDeck().drawCard(), game.getDeck().drawCard())));

    }

}
