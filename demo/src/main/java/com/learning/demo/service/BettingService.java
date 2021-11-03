package com.learning.demo.service;

import com.learning.demo.exception.UnableToPlaceBetException;
import com.learning.demo.model.Bet;
import org.springframework.stereotype.Service;

@Service
public class BettingService {

   public void placeBet(Bet bet) throws UnableToPlaceBetException {
       throw new UnableToPlaceBetException("no money");
   }

}
