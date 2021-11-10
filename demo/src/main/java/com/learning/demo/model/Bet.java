package com.learning.demo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bet {

    private BigDecimal amount;

    private Person person;

}
