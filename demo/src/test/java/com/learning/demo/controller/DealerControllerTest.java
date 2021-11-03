package com.learning.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DealerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/deal",
                String.class);
        Assertions.assertTrue("[]".equals(response));
        Assertions.assertEquals( "[]", response );
    }

    @Test
    public void unableToPlaceBetException() {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/bet",
                String.class);
        log.info(response);
        Assertions.assertTrue("[]".equals(response));
        Assertions.assertEquals( "[]", response );
    }
}
