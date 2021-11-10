package com.learning.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Person {

    @Id
    private int id;

    @Column
    private BigDecimal money;

    @Column
    private String name;

}
