package com.learning.demo.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.learning.demo.exception.BustException;
import com.learning.demo.exception.UnableToPlaceBetException;
import com.learning.demo.model.Bet;
import com.learning.demo.model.Card;
import com.learning.demo.model.Hand;
import com.learning.demo.model.Person;
import com.learning.demo.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


// spring mvc
// jersey


@Controller
@Slf4j
public class DealerController {

    @Autowired
    GameService gameService;

    @RequestMapping(value="/newGame", method = RequestMethod.GET)
    public @ResponseBody String newGame() {

        gameService.newGame();
        return "newGame";
    }

    @RequestMapping(value="/deal", method = RequestMethod.GET)
    public @ResponseBody Hand deal() throws UnableToPlaceBetException, BustException {

        return gameService.deal(new Person());

    }

    @RequestMapping(value="/bet", method = RequestMethod.GET)
    public @ResponseBody void bet() throws UnableToPlaceBetException {
       Bet bet = new Bet();
       bet.setAmount(BigDecimal.TEN);
       bet.setPerson(new Person());

        gameService.placeBet(bet);
    }


    @RequestMapping(value="/game", method = RequestMethod.GET)
    public @ResponseBody String game() throws JsonProcessingException {

        return gameService.getGameResults();
    }

}
