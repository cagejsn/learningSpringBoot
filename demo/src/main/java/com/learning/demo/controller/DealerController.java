package com.learning.demo.controller;


import com.learning.demo.exception.UnableToPlaceBetException;
import com.learning.demo.model.Bet;
import com.learning.demo.model.Card;
import com.learning.demo.service.BettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


// spring mvc
// jersey


@Controller
public class DealerController {

    private ArrayList<Card> deck = new ArrayList<>();


    @Autowired
    BettingService bettingService;


    @RequestMapping(value="/deal", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Card> deal(){
        return new ArrayList<Card>();
    }

    @RequestMapping(value="/bet", method = RequestMethod.GET)
    public @ResponseBody void bet() throws UnableToPlaceBetException {
       Bet bet = new Bet();
       bet.setAmount(10);
       bet.setPerson("Cage");

        bettingService.placeBet(bet);
    }

    protected void shuffle(){
        // TODO shuffle the deck
    }

}
